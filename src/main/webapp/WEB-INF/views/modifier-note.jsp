<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Note" %>
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
    <title>Modifier une Note</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/modifier">Étudiants</a></li>
            <li><a href="/cours/modifier">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier une note</h2>

        <form action="/notes/modifier" method="post">
            <!-- Champ caché pour sauvegarder l'ID de la note -->
            <input type="hidden" name="id" value="${item.id}" >

            <div class="form-group">
                <label for="matiere">Matière</label>
                <input value="${item.matiere}" type="text" name="matiere" id="matiere" placeholder="Matière" required>
            </div>

            <div class="form-group">
                <label for="noteObtenue">Note obtenue</label>
                <input value="${item.noteObtenue}" type="number" name="noteObtenue" id="noteObtenue" placeholder="Note obtenue (0-20)" required min="0" max="20">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" placeholder="Description (optionnel)">${item.description}</textarea>
            </div>

            <div class="form-group">
                <label for="evenement">Événement</label>
                <input value="${item.evenement}" type="text" name="evenement" id="evenement" placeholder="Examen, contrôle... (optionnel)">
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/notes/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
