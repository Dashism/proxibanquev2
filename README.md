ProxiBanqueSIv2_Quentin_Axel
Bienvenue dans ProxiBanqueSI. Ce document a pour objectif de vous aider � utiliser l'application le plus sereinement possible.

Table des Mati�res : 
	1 - Pr�requis
	2 - Execution
	3 - Utilisation
	4 - Fonctionalit�s
	5 - Ressources compl�mentaires

	ATTENTION : Ce document contient des informations importantes pour le fonctionnement de ProxiBanqueSI. Veuillez le lire attentivement
	pour vous assurer la meilleure exp�rience possible. Les d�veloppeurs ne sauraient �tre tenus responsables d'une mauvaise utilisation
	de l'application d�coulant d'une mauvaise lecture de ce document. 
	
1. Pr�requis. 
Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien install� sur votre appareil. Si ce n'est pas le cas, vous 
pouvez le t�l�charger � cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Pensez bien � v�rifier le niveau de votre Syst�me d'exploitation avant de t�l�charger. Vous pouvez v�rifier votre syst�me d'exploitation 
sous Windows dans Panneau de Configuration -> Syst�me et S�curit� -> Syst�me. Votre niveau de Syst�me correspond � l'indication 
32bits ou 64bits, et vous devez t�l�charger la distribution de Java correpondante.
Vous devez �galement avoir un outil pour d�compresser les fichiers install� sur votre ordinateur. Si vous n'en avez pas, 
vous pouvez en t�l�charger un gratuitement ici : https://www.7-zip.org/ 
De m�me t�l�chargez bien la version correspond � votre niveau de Syst�me. 

2. Ex�cution.
Pour Ex�cuter ProxiBanqueSI il vous suffit de d�compresser l'archive qui est en .zip, de rentrer dans le fichier d�compress�,
et de lancer run.bat.

3. Utilisation. 
ProxiBanqueSI est une application permettant de simuler la gestion d'un portefeuille client d'un conseiller bancaire. L'application 
se lance avec toutes les donn�es n�cessaires au fonctionnement des simulations propos�es par l'application. Aucun fichier ext�rieur 
n'est requis.
Dans l'application, la simulation se compose d'une agence, qui poss�de un manager et un conseiller. 
Ce conseiller poss�de 4 clients aux identit�s suivantes (pr�nom, nom dans cet ordre ici): 
 - Martin Dupont
 - Germaine Dupont
 - Red Ketchum
 - Cidolfus Orlandeau
ATTENTION : Il vous faut ces identit�s pour utiliser les diff�rentes fonctionalit�s de l'application. 
ATTENTION : l'application est sensible � la casse. Quand vous entrez une donn�es, assurez-vous bien qu'elle corresponde parfaitement.

4. Fonctionalit�s.
Pour la gestion du portefeuille client, ProxiBanqueSI vous permet ces fonctionalit�s : 
 - Cr�er un nouveau client dans le portefeuille. La cr�ation s'accompagne de la cr�ation d'un ou plusieurs compte(s) bancaire(s) 
et de la cr�ation d'une carte bleue. Il est possible d'utiliser les autres fonctionalit�s sur un client ainsi cr�� 
s'il r�pond aux pr�requis de la fonctionalit�.
 - Consulter la fiche client d'un client : permet d'afficher toutes les informations li�es � un client. Affiche �galement 
les informations des comptes du client. 
 - Supprimer client : Supprimer un client de la base de donn�es.
 - Modifier client : Permet de modifier une information de la liste client. Ne permet pas de modifier les informations de compte.
 - Effectuer un virement : permet d'effectuer un virement entre les comptes Courant et Epargne d'un client.
 - Simuler un Cr�dit de consommation : Permet de lancer une simulation de cr�dit de consommation pour un client.
 - Simuler Cr�dit Immobilier : Permet de lancer une simulation de cr�dit immobilier pour un client. 
 
 ATTENTION : ProxiBanqueSI traite la plupart des erreurs que l'utilisateur pourrait �tre amen� � rencontrer. 
 A la connaissance des d�veloppeurs un cas commun n'est pas pris en compte : 
   - Si des informations sont demand�es pour un client qui n'appartient pas au portefeuille de clients.
      -> Ne renvoie rien. L'application continue de tourner dans le vide.
 Il est possible que d'autres erreurs existent.

5. Ressources compl�mentaires. 
L'application ProxiBanqueSI est livr�e avec deux diagrammes UML repr�sentant : 
	- Les cas d'utilisation.
	- Le Diagramme de Classe.
Ces deux diagrammes sont assez petits, mais il est possible de zoomer dessus pour avoir un acc�s plus clair aux informations.

Il est �galement possible de consulter le code de ProxiBanqueSI � l'adresse suivante : 
https://github.com/LeGreed/proxibanquesiv1_Bixente_Axel


Merci d'avoir lu ce document. Nous vous souhaitons une bonne exp�rience avec ProxiBanqueSI. 
