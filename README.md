ProxiBanqueSIv2_Quentin_Axel
Bienvenue dans ProxiBanqueSI. Ce document a pour objectif de vous aider � utiliser l'application avec la plus grande s�r�nit�.

Table des Mati�res : 
	1 - Pr�requis
	2 - Execution
	3 - Utilisation
	4 - Fonctionalit�s
	5 - Ressources compl�mentaires

	ATTENTION : Ce document contient des informations importantes pour le fonctionnement de ProxiBanqueSI. Veuillez le lire 	attentivement
	pour vous assurer la meilleure exp�rience possible. Les d�veloppeurs ne sauraient �tre tenus responsables d'une mauvaise 	utilisation
	de l'application d�coulant d'une mauvaise ou absence de lecture de ce document. 
	
1. Pr�requis. 
	Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien install� sur votre appareil. Si ce n'est pas le cas, vous 
pouvez le t�l�charger � cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Pensez bien � v�rifier le niveau de votre Syst�me d'exploitation avant de t�l�charger. Vous pouvez v�rifier votre syst�me d'exploitation 
sous Windows dans Panneau de Configuration -> Syst�me et S�curit� -> Syst�me. Votre niveau de Syst�me correspond � l'indication 
32bits ou 64bits, et vous devez t�l�charger la distribution de Java correpondante.
	Vous devez �galement avoir un outil pour d�compresser les fichiers install� sur votre ordinateur. Si vous n'en avez pas, 
vous pouvez en t�l�charger un gratuitement ici : https://www.7-zip.org/ 
De m�me t�l�chargez bien la version correspondant � votre niveau de Syst�me. 
Afin d'utiliser l'application de mani�re optimale, nous vous recommendons d'utiliser Google Chrome. Vous pouvez t�l�charger Google Chrome ici : https://www.google.com/chrome/.
Encore une fois n'oubliez pas de v�rifier le niveau de votre Syst�me.
Pour information, l'application utilise un syst�me de log pour v�rifier son bon d�roulement. Pour y avoir acc�s, il suffit de cr�er un dossier "logs" dans C://Utilisateurs. L'application cr�era un fichier "proxi2logging.log" et enregistrera les messages dedans.

Afin de pouvoir profiter de l'application , il est n�cessaire de t�l�charger et d'installer Tomcat. Il est t�l�chargeable � l'adresse suivante : https://tomcat.apache.org/download-80.cgi.
Veuillez choisir l'installation correspondante � votre syst�me d'exploitation dans "Binary Distributions --> Core". Par exemple, pour Windows 7 ou sup�rieur, veuillez cliquer sur "64-bit Windows.zip".
Une fois l'archive t�l�charg�e, veuillez l'extraire sur votre PC, le dossier de destination n'ayant pas d'importance.
Il est �galement n�cessaire de d�finir une nouvelle variable d'environnement "JRE_HOME". Pour cela, dans l'explorateur de fichiers, faites clic droit sur "Ce PC" -> Propri�t�s. Selectionnez "Param�tres syst�me avanc�s" sur la gauche. Dans la fen�tre ouverte, choisir "variables d'environnement". Sous le tableau "Variables syst�me", Cliquer sur nouvelle : En "Nom de variable" indiquer JRE_HOME et en chemin de variable, il faut r�cup�rer le chemin vers l'installation du jre ( par d�faut C:\\Programmes\\java\\jrexxx ).

Pour avoir acc�s aux donn�es client, veuillez t�l�charger l'application MySQL � l'adresse suivante : https://dev.mysql.com/downloads/windows/installer/8.0.html. Selectionnez l'installation � 313Mo. Bien v�rifier que MySQL Workbench est install�.


2. Ex�cution.
Afin de deployer l'application ProxiBanque, veuillez coller l'archive proxibanque2_Quentin_Axel.war dans le dossier webapps de votre dossier apache-tomcat-8.5.35. 
Ensuite, allez dans le dossier bin et double cliquez sur le fichier "startup.bat".
Attendre qu'un dossier proxibanquev2 apparaisse. 

Veuillez ensuite lancer MySQL Workbench et cr�er un nouveau sch�ma nomm� "proxi2".
Ensuite, selectionner "Server" dans le menu sup�rieur puis "Data import". Selectionner l'option "Import from Self-Contained File et renseigner le chemin vers le fichier str.sql fourni. indiquer "proxi2" dans "Default Target Schema".
Enfin, r�p�ter l'op�ration pr�c�dente avec le script "data.sql" fourni afin d'importer les donn�es proprement dites.

pour lancer l'application, lancer chrome et rentrer l'adresse suivante : http://localhost:8080/proxibanquev2.

Bonne navigation !!!

3. Utilisation. 
ProxiBanqueSI est une application permettant de simuler la gestion d'un portefeuille client d'un conseiller bancaire. 
Afin de ppouvoir lancer l'application vous devez charger une base de donn�es fictives.

Dans l'application, la simulation se compose d'une agence, qui poss�de un manager et un conseiller. 
Ce conseiller poss�de 5 clients aux identit�s distinctes. Chaque client poss�de un nom, un pr�nom, un email, une adresse et une liste de comptes bancaires. 
Il est possible d'explorer l'ensemble des fonctionnalit�s avec les donn�es fournies dans l'application.

Une fois que votre usage de l'application touche � son terme, lancez le fichier "shutdown.bat" dans le m�me dossier que "startup.bat"(Apache Tomcat/bin).

4. Fonctionalit�s.
Pour la gestion du portefeuille client, ProxiBanqueSI vous permet ces fonctionalit�s : 
	-Afficher l'ensemble des clients du conseiller;
	-Modifier les informations des clients; 
	-Afficher les diff�rents comptes que poss�de un cilent;
	-Effectuer un virement bancaire entre deux comptes d'un client.
 
 ATTENTION : ProxiBanqueSI traite la plupart des erreurs que l'utilisateur pourrait �tre amen� � rencontrer. 
 A la connaissance des d�veloppeurs aucune erreur n'est � relever dans cette version de l'application dans le cadre d'une utilisation normale.
 Certaines erreurs non d�tect�es peuvent subsister. 
 Si des erreurs sont d�tect�es, merci de pr�venir au plus vite l'�quipe de d�veloppement. 


5. Ressources compl�mentaires. 
L'application ProxiBanqueSI est livr�e avec deux diagrammes UML repr�sentant : 
	- Les cas d'utilisation;
	- Le Diagramme de Classe;
	- Les screens des maquettes d'�cran. 
	- Le Diagramme des bases de donn�es SQL
	- Les scripts sql pour g�n�rer la base de donn�es. 


Il est �galement possible de consulter le code de ProxiBanqueSI V2 � l'adresse suivante : 
https://github.com/Khantain/proxibanquev2


Merci d'avoir lu ce document. Nous vous souhaitons une bonne exp�rience avec ProxiBanqueSI. 
