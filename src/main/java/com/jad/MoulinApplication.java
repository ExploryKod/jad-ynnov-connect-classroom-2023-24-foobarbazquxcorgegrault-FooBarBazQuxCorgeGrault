package com.jad;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Application JavaFX pour gérer un moulin.
 * Permet d'interagir avec le backend Moulin via une interface graphique.
 */
public class MoulinApplication extends Application {
    
    private Moulin moulin;
    private Label statusLabel;
    private Label grainsCountLabel;
    private Label woodCratesCountLabel;
    private Label marketStatusLabel;
    private TextArea logArea;
    
    @Override
    public void start(Stage primaryStage) {
        // Initialisation du moulin avec une ferme voisine
        moulin = new Moulin(new NeighborFarm());
        
        primaryStage.setTitle("Gestion du Moulin - Système de Tractations");
        
        // Layout principal
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f5f5f5;");
        
        // Titre
        Label titleLabel = new Label("GESTION DU MOULIN");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        titleLabel.setAlignment(Pos.CENTER);
        
        // Section d'état
        VBox statusBox = createStatusSection();
        
        // Section des actions (boutons)
        VBox actionsBox = createActionsSection();
        
        // Section des logs
        VBox logBox = createLogSection();
        
        root.getChildren().addAll(titleLabel, statusBox, actionsBox, logBox);
        
        Scene scene = new Scene(root, 800, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Mise à jour initiale de l'affichage
        updateDisplay();
    }
    
    /**
     * Crée la section d'affichage de l'état du moulin.
     */
    private VBox createStatusSection() {
        VBox statusBox = new VBox(10);
        statusBox.setPadding(new Insets(15));
        statusBox.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        Label statusTitle = new Label("ETAT DU MOULIN");
        statusTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        statusLabel = new Label();
        grainsCountLabel = new Label();
        woodCratesCountLabel = new Label();
        marketStatusLabel = new Label();
        
        statusBox.getChildren().addAll(statusTitle, statusLabel, grainsCountLabel, woodCratesCountLabel, marketStatusLabel);
        
        return statusBox;
    }
    
    /**
     * Crée la section des boutons d'action.
     */
    private VBox createActionsSection() {
        VBox actionsBox = new VBox(10);
        actionsBox.setPadding(new Insets(15));
        actionsBox.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        Label actionsTitle = new Label("TRACTATIONS");
        actionsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Bouton : Ajouter un grain
        Button addGrainButton = new Button("Ajouter un Grain");
        addGrainButton.setPrefWidth(300);
        addGrainButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-size: 14px;");
        addGrainButton.setOnAction(e -> addGrain());
        
        // Bouton : Créer une caisse en bois
        Button addWoodCrateButton = new Button("Creer une Caisse en Bois");
        addWoodCrateButton.setPrefWidth(300);
        addWoodCrateButton.setStyle("-fx-background-color: #8b4513; -fx-text-fill: white; -fx-font-size: 14px;");
        addWoodCrateButton.setOnAction(e -> addWoodCrate());
        
        // Bouton : Créer/Associer un marché
        Button createMarketButton = new Button("Creer/Associer un Marche");
        createMarketButton.setPrefWidth(300);
        createMarketButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 14px;");
        createMarketButton.setOnAction(e -> createMarket());
        
        // Bouton : Désassocier le marché
        Button removeMarketButton = new Button("Desassocier le Marche");
        removeMarketButton.setPrefWidth(300);
        removeMarketButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 14px;");
        removeMarketButton.setOnAction(e -> removeMarket());
        
        // Bouton : Réinitialiser
        Button resetButton = new Button("Reinitialiser le Moulin");
        resetButton.setPrefWidth(300);
        resetButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-size: 14px;");
        resetButton.setOnAction(e -> resetMoulin());
        
        HBox buttonBox1 = new HBox(10, addGrainButton, addWoodCrateButton);
        HBox buttonBox2 = new HBox(10, createMarketButton, removeMarketButton);
        
        actionsBox.getChildren().addAll(actionsTitle, buttonBox1, buttonBox2, resetButton);
        
        return actionsBox;
    }
    
    /**
     * Crée la section des logs.
     */
    private VBox createLogSection() {
        VBox logBox = new VBox(10);
        logBox.setPadding(new Insets(15));
        logBox.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 5; -fx-background-radius: 5;");
        
        Label logTitle = new Label("JOURNAL DES ACTIVITES");
        logTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(150);
        logArea.setStyle("-fx-font-family: monospace; -fx-font-size: 12px;");
        
        logBox.getChildren().addAll(logTitle, logArea);
        
        return logBox;
    }
    
    /**
     * Ajoute un grain au moulin.
     */
    private void addGrain() {
        GrainFarmProductor grain = new GrainFarmProductor();
        moulin.addGrain(grain);
        log("Grain ajoute au moulin");
        updateDisplay();
    }
    
    /**
     * Crée une caisse en bois.
     */
    private void addWoodCrate() {
        moulin.addWoodCrateProduction();
        log("Nouvelle caisse en bois creee");
        updateDisplay();
    }
    
    /**
     * Crée ou associe un marché au moulin.
     */
    private void createMarket() {
        WindmillMarket market = new WindmillMarket(moulin);
        log("Marche cree et associe au moulin");
        updateDisplay();
    }
    
    /**
     * Désassocie le marché du moulin.
     */
    private void removeMarket() {
        if (moulin.getWindmillMarket() != null) {
            moulin.setWindmillMarket(null);
            log("Marche desassocie du moulin");
        } else {
            log("Aucun marche associe");
        }
        updateDisplay();
    }
    
    /**
     * Réinitialise le moulin.
     */
    private void resetMoulin() {
        moulin = new Moulin(new NeighborFarm());
        log("Moulin reinitialise");
        updateDisplay();
    }
    
    /**
     * Met à jour l'affichage de l'état du moulin.
     */
    private void updateDisplay() {
        // État général
        statusLabel.setText("Moulin operationnel");
        statusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #27ae60;");
        
        // Nombre de grains
        int grainsCount = moulin.getGrains().size();
        grainsCountLabel.setText("Grains stockes : " + grainsCount);
        grainsCountLabel.setStyle("-fx-font-size: 14px;");
        
        // Nombre de caisses en bois
        int woodCratesCount = moulin.getWoodCrateProductions().size();
        woodCratesCountLabel.setText("Caisses en bois : " + woodCratesCount);
        woodCratesCountLabel.setStyle("-fx-font-size: 14px;");
        
        // État du marché
        WindmillMarket market = moulin.getWindmillMarket();
        if (market != null) {
            marketStatusLabel.setText("Marche associe : Oui");
            marketStatusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #27ae60;");
        } else {
            marketStatusLabel.setText("Marche associe : Non");
            marketStatusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #e74c3c;");
        }
    }
    
    /**
     * Ajoute un message au journal.
     */
    private void log(String message) {
        String timestamp = java.time.LocalTime.now().toString().substring(0, 8);
        logArea.appendText("[" + timestamp + "] " + message + "\n");
        logArea.setScrollTop(Double.MAX_VALUE); // Scroll vers le bas
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

