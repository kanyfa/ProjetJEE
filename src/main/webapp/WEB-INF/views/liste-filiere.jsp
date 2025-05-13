<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Liste des filières</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
  <h1>Système de gestion scolaire</h1>
  <nav>
    <ul>
      <li><a href="/accueil">Accueil</a></li>
      <li><a href="/etudiants/lister">Étudiants</a></li>
      <li><a href="/cours/lister">Cours</a></li>
      <li><a href="" class="active">Filières</a></li>
      <li><a href="/notes/lister">Notes</a></li>
    </ul>
  </nav>
</header>

<main>
  <section class="student-list">
    <div class="list-header">
      <h2>Liste des filières</h2>
      <a href="/filieres/ajouter" class="btn">+ Nouvelle filière</a>
    </div>

    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Nom</th>
        <th>Département</th>
        <th>Responsable</th>
        <th>Capacité</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${filieres}" var="filiere">
        <tr>
          <td>${filiere.id}</td>
          <td>${filiere.code}</td>
          <td>${filiere.nom}</td>
          <td>${filiere.departement}</td>
          <td>${filiere.prenomResponsable} ${filiere.nomResponsable}</td>
          <td>${filiere.capacite}</td>
          <td class="actions">
            <a class="btn-details">Détails</a>
            <a href="${pageContext.request.contextPath}/filieres/modifier?id=${filiere.id}" class="btn-edit">Modifier</a>

            <!-- Bouton de suppression avec confirmation -->
            <a href="${pageContext.request.contextPath}/filieres/supprimer?id=${filiere.id}"
               class="btn-delete"
               onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette filière ?');">
              Supprimer
            </a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</main>
</body>
</html>
