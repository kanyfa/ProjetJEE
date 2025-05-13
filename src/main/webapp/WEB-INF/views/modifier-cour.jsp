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
    <title>Modifier un cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/modifier">Étudiants</a></li>
            <li><a href="" class="active">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/modifier">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier un cours</h2>

        <form action="/cours/modifier" method="post">
            <!-- Champ caché pour sauvegarder l'ID du cours -->
            <input type="hidden" name="id" value="${item.id}" >

            <div class="form-group">
                <label for="code">Code</label>
                <input value="${item.code}" type="text" name="code" id="code" placeholder="Code" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input value="${item.nom}" type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" placeholder="Description">${item.description}</textarea>
            </div>

            <div class="form-group">
                <label for="professeur">Professeur</label>
                <input value="${item.professeur}" type="text" name="professeur" id="professeur" placeholder="Nom du professeur">
            </div>

            <div class="form-group">
                <label for="duree">Durée (heures)</label>
                <input value="${item.duree}" type="number" name="duree" id="duree" placeholder="Durée en heures" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/cours/lister" class="btn btn-secondary">Annuler</a>
                <a href="/cours/supprimer" class="btn btn-secondary">Supprimer</a>

            </div>
        </form>
    </section>
</main>
</body>
</html>
