<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Outil de virement</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty transferRate}">
		<h1>Erreur. Le compte a debiter aura un solde negatif avec le
			montant renseign�</h1>
		<a href="index.html">
			<button>J'approuve mon idiotie et m'en vais</button>
		</a>
	</c:if>
	<section class="head"></section>

	<c:if test="${fn:length(accounts) > 1}">
	<h1 class="page-title">Transfert pour ${client.firstname} ${client.lastname }</h1>
		<div class="transfer-container">
			<form method="post" action="">
				<div class="lists-container">
					<div class="debit-list">
						<fieldset>
							<legend> Compte � d�biter </legend>
							<c:forEach var="account" items="${accounts}">
								<div>
									<input id="compteADebiter" type="radio" name="compteADebiter"
										value="${account.id}"> <label for="compteADebiter">Compte
										n�${account.number} ------------ Solde :
										${account.balance}&#8364</label>
								</div>
							</c:forEach>
						</fieldset>
					</div>
					<div class="credit-list">
						<fieldset>
							<legend> Compte � cr�diter </legend>
							<c:forEach var="account" items="${accounts}">
								<div>
									<input id="compteACrediter" type="radio" name="compteACrediter"
										value="${account.id}"> <label for="compteACrediter">Compte
										: n�${account.number} ------------ Solde :
										${account.balance}&#8364</label>
								</div>
							</c:forEach>
						</fieldset>
					</div>
				</div>
				<label for="value"> Montant du virement</label> <input
					type="number" name="value" id="value">
				<button>Confirmer</button>
			</form>
		</div>
	</c:if>
	<div class="footer-button">
		<a href="index.html">
			<button>Retour � l'accueil</button>
		</a>
	</div>
</body>
</html>