<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Cour" %>
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
    <title>Ajouter un Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/ajouter">Etudiants</a></li>
            <li><a href="cours/ajouter" class="active">Cours</a></li>
            <li><a href="/filieres/ajouter">Filières</a></li>
            <li><a href="notes/ajouter">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter un nouveau cours</h2>

        <form action="/cours/ajouter" method="post">
            <div class="form-group">
                <label for="code">Code</label>
                <input type="text" name="code" id="code" placeholder="Code" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" placeholder="Description"></textarea>
            </div>

            <div class="form-group">
                <label for="professeur">Professeur</label>
                <input type="text" name="professeur" id="professeur" placeholder="Nom du professeur">
            </div>

            <div class="form-group">
                <label for="duree">Durée (en heures)</label>
                <input type="number" name="duree" id="duree" placeholder="Durée en heures" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="/cours/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
