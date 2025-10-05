package com.example.todolist.config;

import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        // Créer des utilisateurs
        User user1 = new User("alice", "alice@example.com");
        User user2 = new User("bob", "bob@example.com");
        User user3 = new User("charlie", "charlie@example.com");
        
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        
        // Créer des tâches sans relations d'abord
        Task task1 = new Task("Apprendre Spring Boot", "Comprendre les bases de Spring Boot et créer une application TODO");
        task1.setDueDate(LocalDateTime.now().plusDays(7));
        
        Task task2 = new Task("Configurer la base de données", "Mettre en place H2 et créer les entités JPA");
        task2.setCompleted(true);
        
        Task task3 = new Task("Créer les templates", "Développer les vues Thymeleaf pour l'interface utilisateur");
        task3.setDueDate(LocalDateTime.now().plusDays(3));
        
        Task task4 = new Task("Tests unitaires", "Écrire les tests pour les contrôleurs et services");
        task4.setDueDate(LocalDateTime.now().plusDays(5));
        
        // Sauvegarder les tâches
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        
        // Maintenant créer les relations
        Set<User> usersTask1 = new HashSet<>();
        usersTask1.add(user1);
        usersTask1.add(user2);
        task1.setUsers(usersTask1);
        
        Set<User> usersTask2 = new HashSet<>();
        usersTask2.add(user1);
        task2.setUsers(usersTask2);
        
        Set<User> usersTask3 = new HashSet<>();
        usersTask3.add(user2);
        usersTask3.add(user3);
        task3.setUsers(usersTask3);
        
        Set<User> usersTask4 = new HashSet<>();
        usersTask4.add(user3);
        task4.setUsers(usersTask4);
        
        // Sauvegarder les tâches avec leurs relations
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        
        System.out.println("Données initiales créées avec succès !");
    }
}
