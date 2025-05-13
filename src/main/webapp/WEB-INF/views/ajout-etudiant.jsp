<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Etudiant" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alndiaye
  Date: 30-04-2025
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un étudiant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/ajouter" class="active">Étudiants</a></li>
            <li><a href="/cours/ajouter">Cours</a></li>
            <li><a href="/filieres/ajouter">Filières</a></li>
            <li><a href="/notes/ajouter">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter un nouvel étudiant</h2>

        <form action="/etudiants/ajouter" method="post">
            <div class="form-group">
                <label for="matricule">Matricule</label>
                <input type="text" name="matricule" id="matricule" placeholder="Matricule" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input type="text" name="prenom" id="prenom" placeholder="Prénom" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" name="email" id="email" placeholder="Email" required>
            </div>

            <div class="form-group">
                <label for="telephone">Téléphone</label>
                <input type="text" name="telephone" id="telephone" placeholder="Téléphone">
            </div>

            <div class="form-group">
                <label for="filiere">Filière</label>
                <select id="filiere" name="filiere">
                    <option value="Informatique">Informatique</option>
                    <option value="Gestion">Gestion</option>
                    <option value="Automobile">Automobile</option>
                </select>
            </div>

            <div class="form-group">
                <label for="numeroCarteEtudiant">Numéro de carte étudiant</label>
                <input type="text" name="numeroCarteEtudiant" id="numeroCarteEtudiant" placeholder="Numéro de carte étudiant">
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="/etudiants/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>

