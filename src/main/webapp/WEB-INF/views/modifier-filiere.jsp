<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Filiere" %>
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
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

</head>
<body>
<header>
  <h1>Système de gestion scolaire</h1>
  <nav>
    <ul>
      <li><a href="/accueil">Accueil</a></li>
      <li><a href="/etudiants/modifier">Etudiants</a></li>
      <li><a href="cours/modifier">Cours</a></li>
      <li><a href="" class="active">Filières</a></li>
      <li><a href="notes/modifier">Notes</a></li>
    </ul>
  </nav>
</header>

<main>
  <section class="form-container">
    <h2>Modifier une nouvelle filière</h2>

    <form action="/filieres/modifier" method="post">
      <!-- champ caché pour sauvegader l'id de la filiere -->
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
        <label for="nom">Département</label>
        <select value="${item.departement}" id="departement" name="departement">
          <option value="TIC">TIC</option>
          <option value="AUTO">Automobile</option>
        </select>
      </div>

      <div class="form-group">
        <label for="nomResponsable">Nom</label>
        <input value="${item.nomResponsable}" type="text" name="nomResponsable" id="nomResponsable" placeholder="nomResponsable">
      </div>
      <div class="form-group">
        <label for="prenomResponsable">Prénom</label>
        <input value="${item.prenomResponsable}" type="text" name="prenomResponsable" id="prenomResponsable" placeholder="prenomResponsable">
      </div>
      <div class="form-group">
        <label for="capacite">Capacité</label>
        <input value="${item.capacite}" type="number" name="capacite" id="capacite" placeholder="capacite">
      </div>

      <div class="form-buttons">
        <button type="submit" class="btn btn-primary">Modifier</button>
        <a href="/filieres/lister" class="btn btn-secondary">Annuler</a>
      </div>
    </form>
  </section>
</main>
</body>
</html>
