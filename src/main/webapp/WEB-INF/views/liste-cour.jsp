<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Étudiants</a></li>
            <li><a href="" class="active">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="course-list">
        <div class="list-header">
            <h2>Liste des cours</h2>
            <a href="/cours/ajouter" class="btn">+ Nouveau cours</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Professeur</th>
                <th>Durée (heures)</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${cours}" var="cour">
                <tr>
                    <td>${cour.id}</td>
                    <td>${cour.code}</td>
                    <td>${cour.nom}</td>
                    <td>${cour.description}</td>
                    <td>${cour.professeur}</td>
                    <td>${cour.duree}</td>
                    <td class="actions">
                        <a class="btn-details">Détails</a>
                        <a href="${pageContext.request.contextPath}/cours/modifier?id=${cour.id}" class="btn-edit">Modifier</a>

                        <!-- Bouton de suppression avec confirmation -->
                        <a href="${pageContext.request.contextPath}/cours/supprimer?id=${cour.id}" class="btn-delete"
                           onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce cours ?');">Supprimer</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
