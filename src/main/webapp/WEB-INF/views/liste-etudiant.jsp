<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des étudiants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="" class="active">Étudiants</a></li>
            <li><a href="/cours/lister">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des étudiants</h2>
            <a href="/etudiants/ajouter" class="btn">+ Nouvel étudiant</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Matricule</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Filière</th>
                <th>Carte étudiant</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${etudiants}" var="etudiant">
                <tr>
                    <td>${etudiant.id}</td>
                    <td>${etudiant.matricule}</td>
                    <td>${etudiant.nom}</td>
                    <td>${etudiant.prenom}</td>
                    <td>${etudiant.email}</td>
                    <td>${etudiant.telephone}</td>
                    <td>${etudiant.filiere}</td>
                    <td>${etudiant.numeroCarteEtudiant}</td>
                    <td class="actions">
                        <a href="${pageContext.request.contextPath}/etudiants/details?id=${etudiant.id}" class="btn-details">Détails</a>
                        <a href="${pageContext.request.contextPath}/etudiants/modifier?id=${etudiant.id}" class="btn-edit">Modifier</a>

                        <!-- Bouton de suppression avec confirmation -->
                        <a href="${pageContext.request.contextPath}/etudiants/supprimer?id=${etudiant.id}"
                           class="btn-delete"
                           onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?');">
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
