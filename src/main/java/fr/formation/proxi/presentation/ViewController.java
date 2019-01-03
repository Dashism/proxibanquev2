package fr.formation.proxi.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.proxi.ProxiConstants;
import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.AdvisorService;
import fr.formation.proxi.metier.service.BankCardService;
import fr.formation.proxi.metier.service.ClientService;

@Controller
@RequestMapping("/")
public class ViewController {

	private static final Logger LOGGER = Logger.getLogger(ViewController.class);
	
	@Autowired
	private AdvisorService advisorService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private BankCardService bankCardService;

	@RequestMapping({ "", "index" })
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		// Lorsque le LoginModule de JAAS effectue le login avec succès,
		// il rempli les différents objets java.security.Principal avec les
		// informations de connexion : nom d'utilisateur et rôle pour nous ici.
		// Il y a donc un Principal pour notre nom de conseiller, et un autre
		// que nous n'utilisons pas pour le nom du rôle.
		// Etant donné que JAAS a rempli le UserPrincipal avec notre nom de
		// conseiller, il nous suffit de le récupérer.

		// Vérifier si le conseiller est dans la session utilisateur.
		if (request.getSession().getAttribute("advisor") == null) {
			// L'attribut n'est pas encore en session.
			// Récupérer le nom du conseiller.
			String advisor = request.getUserPrincipal().getName();
			// Ajout de l'attribut dans la session de l'utilisateur pour accéder
			// à cette information depuis les pages JSP.
			request.getSession().setAttribute("advisor", advisor);
		}
		String advisorName = request.getUserPrincipal().getName();
		Integer advisorId = this.advisorService.getAdvisorIdByName(advisorName);
		List<Client> clients = this.advisorService.getClientsByAdvisorId(advisorId);

		request.setAttribute("clients", clients);
		LOGGER.info("Liste des clients chargée");
		return mav;
	}
	
	@RequestMapping("modify")
	public ModelAndView showEditClient(Integer id) {
		ModelAndView mav = new ModelAndView("editor");
		mav.addObject("client", this.clientService.read(id));
		return mav;
	}
	
	@RequestMapping(path="modify", method=RequestMethod.POST)
	public ModelAndView validateEditClient(Client client) {
		ModelAndView mav = new ModelAndView("edit_OK");
		Client clientBdd = this.clientService.read(client.getId());
		client.setAccounts(clientBdd.getAccounts());
		client.setCard(clientBdd.getCard());
		this.clientService.update(client);
		return mav;
	}
	
	@RequestMapping("account")
	public ModelAndView showAccountsClient(Integer id) {
		ModelAndView mav = new ModelAndView("account");
		List<Account> currentAccounts= this.accountService.getAllCurrentAccounts(id);
		List<Account> savingAccounts= this.accountService.getAllSavingAccounts(id);
		Client client = this.clientService.read(id);
		
		mav.addObject("currentAccounts",currentAccounts);
		mav.addObject("savingAccounts",savingAccounts);
		mav.addObject("id",id);
		mav.addObject("client",client);
		LOGGER.info("Comptes du client " + client.getLastname() + " " + client.getFirstname() + " chargés");
		return mav;
	}
	
	@RequestMapping("transfer")
	public ModelAndView showTransferClient(Integer id) {
		ModelAndView mav = new ModelAndView();
		Client client = this.clientService.read(id);
		List<Account> accounts = this.accountService.getAll(id);
		if (accounts.size() <= 1) {
			mav.addObject("client", client);
			mav.setViewName("error_transfer");
		} else {
			mav.addObject("accounts", accounts);
			mav.addObject("client", client);
			mav.setViewName("transfer");
		}
		return mav;
	}
	
	@RequestMapping(path="transfer", method=RequestMethod.POST)
	public ModelAndView showTransferClient(Float value, Integer compteADebiter, Integer compteACrediter, Integer id) {
		ModelAndView mav = new ModelAndView();
		Boolean transferOK = this.clientService.transfer(value, compteADebiter, compteACrediter, id);

		if (!transferOK) {
			mav.addObject("transferRate", transferOK);
			mav.setViewName("transfer");
		} else {
			mav.setViewName("transfer_OK");
		}
		return mav;
	}
	
	@RequestMapping("card")
	public ModelAndView showCardClient(Integer id) {
		ModelAndView mav = new ModelAndView("card");
		Client client = this.clientService.read(id);
		mav.addObject("client", client);
		return mav;
	}
	
	@RequestMapping(path="card", method=RequestMethod.POST)
	public String validateCardClient(Integer id, String number, String type) {
		BankCard newCard = this.bankCardService.create(number, type);
		Client client = this.clientService.read(id);
		client.setCard(newCard);
		this.clientService.update(client);
		return ProxiConstants.REDIRECT_TO_INDEX;
	}
	
	@RequestMapping("delete_card")
	public String deleteCardClient(Integer id) {
		Client client = this.clientService.read(id);
		client.setCard(null);
		this.clientService.update(client);
		this.bankCardService.delete(id);
		return ProxiConstants.REDIRECT_TO_INDEX;
	}

	/**
	 * Déconnexion avec invalidation de la session et des attributs de session
	 * Spring.
	 * 
	 * @param session la session HTTP (que Tomcat avec un JSESSIONID) associée à
	 *                l'utilisateur ayant effectué la requête.
	 * @return String la chaine de redirection vers index.
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session, SessionStatus status) {
		session.invalidate();
		return ProxiConstants.REDIRECT_TO_INDEX;
	}
}
