<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Salariés - Projet Java</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f9;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #1a7a89;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }
        h2 {
            color: #1a7a89;
            border-bottom: 2px solid #1a7a89;
            padding-bottom: 5px;
            margin-top: 30px;
            font-size: 1.8rem;
        }
        p {
            margin: 10px 0;
        }
        ul {
            margin: 15px 0;
            padding-left: 20px;
        }
        li {
            margin-bottom: 10px;
        }
        .section {
            margin-bottom: 30px;
        }
        .highlight {
            background-color: #e8f5f5;
            padding: 10px;
            border-radius: 5px;
            font-weight: bold;
            color: #333;
        }
        .code {
            background: #f1f1f1;
            padding: 10px;
            border-radius: 5px;
            font-family: 'Courier New', Courier, monospace;
            margin: 10px 0;
        }
        footer {
            text-align: center;
            margin-top: 30px;
            font-size: 0.9rem;
            color: #666;
        }
    </style>
</head>
<body>

    <h1>Gestion des Salariés - Projet Java</h1>

    <div class="section">
        <p>
            Ce projet a été réalisé dans le cadre de la première année de <strong>BTS SIO</strong>. Grâce au langage de programmation 
            <strong>Java</strong>, l’objectif était de développer une application pour une entreprise permettant de gérer les salariés. 
            Voici les principales fonctionnalités initiales et les évolutions apportées :
        </p>
    </div>

    <div class="section">
        <h2>Fonctionnalités principales :</h2>
        <ul>
            <li>Trier les salariés par type de service.</li>
            <li>Consulter les informations des salariés.</li>
            <li>Ajouter ou modifier les données des salariés.</li>
        </ul>
    </div>

    <div class="section">
        <h2>Mise à jour :</h2>
        <p>
            Début septembre, en début de deuxième année, une mise à jour a été effectuée pour inclure une nouvelle fonctionnalité :
        </p>
        <ul>
            <li>
                <strong>Gestion des formations :</strong> possibilité de consulter les formations effectuées par les salariés 
                et d’en ajouter parmi celles disponibles.
            </li>
        </ul>
    </div>

    <div class="section">
        <h2>Configuration requise et mise en place :</h2>

        <h3>1. Ajouter les fichiers nécessaires</h3>
        <p class="highlight">
            Pour que le projet fonctionne correctement, vous devez :
        </p>
        <ul>
            <li>Ajouter le fichier <strong>.jar</strong> correspondant à <strong>jCalendar</strong>.</li>
            <li>Ajouter le connecteur MySQL.</li>
        </ul>
        <p>Ces fichiers se trouvent dans le dossier <em>Ressources nécessaires</em> du projet.</p>

        <h3>2. Initialiser la base de données</h3>
        <p>
            Exécutez le fichier <strong>SQL</strong> fourni avec le projet. Ce fichier contient la structure de la base de données 
            ainsi que les données nécessaires au bon fonctionnement de l’application.
        </p>

        <h3>3. Lancer le projet</h3>
        <p>
            Une fois les étapes précédentes terminées, vous pouvez :
        </p>
        <ul>
            <li>Ouvrir le projet dans votre environnement de développement (Eclipse, IntelliJ, NetBeans, etc.).</li>
            <li>Exécuter l’application et accéder à toutes ses fonctionnalités.</li>
        </ul>
    </div>

    <div class="section">
        <h2>À propos</h2>
        <p>
            Ce projet a été conçu pour répondre aux besoins de gestion des salariés dans une entreprise. Il s'agit d'un projet éducatif 
            visant à mettre en pratique les compétences acquises en développement Java, gestion de bases de données, et en création 
            d’interfaces utilisateur.
        </p>
        <p>Pour toute question ou problème, n’hésitez pas à me contacter.</p>
    </div>

    <footer>
        <p>© 2025 - Gestion des Salariés - Projet Java</p>
    </footer>

</body>
</html>
