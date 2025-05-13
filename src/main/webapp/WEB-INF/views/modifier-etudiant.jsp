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
    <title>Modifier un étudiant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/modifier" class="active">Étudiants</a></li>
            <li><a href="/cours/modifier">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/modifier">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier un étudiant</h2>

        <form action="/etudiants/modifier" method="post">
            <!-- Champ caché pour sauvegarder l'ID de l'étudiant -->
            <input type="hidden" name="id" value="${item.id}">

            <div class="form-group">
                <label for="matricule">Matricule</label>
                <input value="${item.matricule}" type="text" name="matricule" id="matricule" placeholder="Matricule" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input value="${item.nom}" type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input value="${item.prenom}" type="text" name="prenom" id="prenom" placeholder="Prénom" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input value="${item.email}" type="email" name="email" id="email" placeholder="Email" required>
            </div>

            <div class="form-group">
                <label for="telephone">Téléphone</label>
                <input value="${item.telephone}" type="text" name="telephone" id="telephone" placeholder="Téléphone">
            </div>

            <div class="form-group">
                <label for="filiere">Filière</label>
                <select id="filiere" name="filiere">
                    <option value="Informatique" ${item.filiere == 'Informatique' ? 'selected' : ''}>Informatique</option>
                    <option value="Gestion" ${item.filiere == 'Gestion' ? 'selected' : ''}>Gestion</option>
                    <option value="Automobile" ${item.filiere == 'Automobile' ? 'selected' : ''}>Automobile</option>
                </select>
            </div>

            <div class="form-group">
                <label for="numeroCarteEtudiant">Numéro de carte étudiant</label>
                <input value="${item.numeroCarteEtudiant}" type="text" name="numeroCarteEtudiant" id="numeroCarteEtudiant" placeholder="Numéro de carte étudiant">
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/etudiants/lister" class="btn btn-secondary">Annuler</a>
                <a href="/etudiants/supprimer" class="btn btn-secondary">Supprimer</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>


