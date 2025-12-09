# 🖥️ Frontend JavaFX - Gestion du Moulin

## Description

Application graphique JavaFX pour gérer et interagir avec le backend `Moulin`. L'interface permet de réaliser toutes les tractations (opérations) du moulin via des boutons.

## 🚀 Lancement de l'application

### Méthode 1 : Avec Maven (recommandé)

```bash
mvn javafx:run
```

### Méthode 2 : Compilation puis exécution

```bash
# Compiler le projet
mvn clean compile

# Exécuter l'application
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp target/classes com.jad.MoulinApplication
```

### Méthode 3 : Créer un JAR exécutable

```bash
mvn clean package
java -jar target/FooBarBazQuxCorgeGrault-1.0-SNAPSHOT.jar
```

## 📋 Fonctionnalités

### Interface Graphique

L'application affiche :

1. **📊 État du Moulin**
   - Statut opérationnel
   - Nombre de grains stockés
   - Nombre de caisses en bois créées
   - État de l'association avec le marché

2. **⚙️ Boutons de Tractations**
   - **🌾 Ajouter un Grain** : Ajoute un `GrainFarmProductor` au moulin
   - **📦 Créer une Caisse en Bois** : Crée un `WoodCrateProduction` (composition)
   - **🏪 Créer/Associer un Marché** : Crée et associe un `WindmillMarket` au moulin
   - **❌ Désassocier le Marché** : Retire l'association avec le marché
   - **🔄 Réinitialiser** : Remet le moulin à zéro

3. **📝 Journal des Activités**
   - Affiche toutes les actions effectuées avec horodatage

## 🎨 Architecture

```
MoulinApplication (Frontend JavaFX)
    ↓
Moulin (Backend)
    ├── NeighborFarm (Association)
    ├── GrainFarmProductor[] (Agrégation)
    ├── CabbageFarm (Composition)
    ├── WoodCrateProduction[] (Composition)
    └── WindmillMarket (Association bidirectionnelle)
```

## 🔧 Structure du Code

- **MoulinApplication.java** : Classe principale JavaFX qui gère l'interface
- **Moulin.java** : Backend métier (déjà existant)
- Les autres classes : Modèles du domaine

## 📝 Exemple d'utilisation

1. Lancer l'application
2. Cliquer sur "🌾 Ajouter un Grain" plusieurs fois
3. Cliquer sur "📦 Créer une Caisse en Bois" pour créer des espaces de stockage
4. Cliquer sur "🏪 Créer/Associer un Marché" pour associer un marché
5. Observer l'état du moulin se mettre à jour en temps réel

## 🐛 Dépannage

### JavaFX non trouvé

Si vous avez une erreur "JavaFX not found", assurez-vous que :
- JavaFX est bien dans les dépendances Maven (déjà ajouté)
- Vous utilisez Java 21 ou supérieur

### Module path error

Si vous avez une erreur de module path, utilisez la commande Maven :
```bash
mvn javafx:run
```

## 🎯 Prochaines améliorations possibles

- [ ] Sauvegarde/Chargement de l'état du moulin
- [ ] Graphiques de statistiques
- [ ] Export des données en CSV/JSON
- [ ] Mode simulation avec événements automatiques
- [ ] Thème sombre/clair

