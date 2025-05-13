<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des notes</title>
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
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des notes</h2>
            <a href="/notes/ajouter" class="btn">+ Nouvelle note</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Matière</th>
                <th>Note obtenue</th>
                <th>Description</th>
                <th>Événement</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${notes}" var="note">
                <tr>
                    <td>${note.id}</td>
                    <td>${note.matiere}</td>
                    <td>${note.noteObtenue}</td>
                    <td>${note.description}</td>
                    <td>${note.evenement}</td>
                    <td class="actions">
                        <a class="btn-details">Détails</a>
                        <a href="${pageContext.request.contextPath}/notes/modifier?id=${note.id}" class="btn-edit">Modifier</a>

                        <!-- Bouton de suppression avec confirmation -->
                        <a href="${pageContext.request.contextPath}/notes/supprimer?id=${note.id}"
                           class="btn-delete"
                           onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette note ?');">
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
