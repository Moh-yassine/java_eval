# TODO List Application - Spring Boot

### Modèles de données
- **User** : Utilisateurs avec username, email et tâches assignées
- **Task** : Tâches avec titre, description, statut, dates et utilisateurs assignés
- **Relation Many-to-Many** : Un utilisateur peut avoir plusieurs tâches, une tâche peut être assignée à plusieurs utilisateurs

### URLs disponibles
- `/` - Page d'accueil
- `/users` - Liste de tous les utilisateurs
- `/users/{id}` - Détail d'un utilisateur spécifique
- `/tasks` - Liste de toutes les tâches
- `/tasks/{id}` - Détail d'une tâche spécifique

### Base de données
- **H2 Database** en mémoire avec console accessible à `/h2-console`
- **Données initiales** créées automatiquement au démarrage
- **Tables** : users, tasks, user_tasks (table de jointure)

## Prérequis

- Java 17 ou supérieur
- Maven 3.6 ou supérieur

## Installation et démarrage

1. **Cloner le repository**
   ```bash
   git clone <url-du-repository>
   cd java_eval
   ```

2. **Compiler l'application**
   ```bash
   mvn clean compile
   ```

3. **Démarrer l'application**
   ```bash
   mvn spring-boot:run
   ```

4. **Accéder à l'application**
   - Application web : http://localhost:8080
   - Console H2 : http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:tododb`
     - Username: `sa`
     - Password: (vide)


## Technologies utilisées

- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Gestion des données
- **H2 Database** - Base de données en mémoire
- **Thymeleaf** - Moteur de templates
- **Bootstrap 5** - Framework CSS
- **Maven** - Gestion des dépendances

## Développement

### Commandes utiles

```bash
# Nettoyer et compiler
mvn clean compile

# Exécuter les tests
mvn test

# Créer un package JAR
mvn package

# Exécuter le JAR
java -jar target/todo-list-1.0.0.jar
```

### Console H2

Pour accéder à la console H2 et explorer la base de données :
1. Aller sur http://localhost:8080/h2-console
2. Utiliser les paramètres :
   - JDBC URL: `jdbc:h2:mem:tododb`
   - Username: `sa`
   - Password: (laisser vide)
