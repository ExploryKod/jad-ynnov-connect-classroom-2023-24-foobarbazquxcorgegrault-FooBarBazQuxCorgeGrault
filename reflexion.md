## POO en Java : explications de notre logique

Nous avons ces class : 
> nom initial > nom refactoré (clean code: naming) 

- Bar
- Baz > GrainFarmProductor (Plusieurs objets = "grains")
- Corge
- Foo > Moulin
- Grault > WoodCratesProduction (Production de caisses en bois)
- Qux

Foo est la class principale qui gère les autres class. Par analogie c'est un moulin qui organise les flux de denrées.

### Foo (Moulin) - Bar : association unidirectionnel 
**Bar est une ferme voisine** : elle est autonome, peut exister sans le moulin (Foo). Foo connaît Bar : Foo peut prendre en compte les demandes de Bar car il sait lire les lettres envoyées par Bar (getBar). Bar n'a en revanche pas connaissance de Foo et n'aura donc aucune réponse en retour 

### Baz (Producteur de graines : GrainFarmProductor) et Foo (Moulin): Agrégation
Baz est aussi un voisin, une ferme voisine qui produit des baz (grain). Il existe un contrat entre Baz et Foo : Foo a une relation commerciale avec Baz et Foo peut collecter et stocker des grains venant de chez Baz dans le moulin (les bazs). Chaque grain (baz) existe indépendament et Foo peut avoir plusieurs bazs.

### Qux (Ferme de choux: CabbageFarm) et Foo (Moulin): composition
Qux est créé par Foo, le moulin (Foo) a donc sa propre ferme de choux (Qux) pour contrôler une partie de la chaîne de production (matières premières). Cette ferme de choux (Qux) est créé par Foo (Moulin) dés sa naissance. Sans Foo (Moulin), la ferme de choux (Qux) disparait car c'est une composition.

### Grault (caisse en bois issue d'une forêt) et Foo (Moulin) : composition avec collection 
> A la demande du moulin, un Grault est créé et ce dernier créé des graults c'est à dire des espaces de stockages sur-mesure pour le moulin seulement

***Détails:***<br>
Grault est créé par Foo si ce dernier a besoin de bois pour ses réparation. Grault est une forêt privé qui produit caisses de stockage en bois pour le moulin ce qui augmente la surface de stockage de Foo. Le moulin peut demander à la forêt et ses bûcherons de créer des espaces de stockage sur mesure pour lui (Foo > moulin). Chaque espace de stockage ne peut être créer que pour le Moulin car c'est sur-mesure.

### Corge et Foo : association bidirectionnelle

Le moulin (Foo) a un marché (Corge) pour vendre ses denrées, il ne peut vendre que sur ce marché : la dirigeante du marché est marié au dirigeant du moulin. Le moulin ne pourrait donc vendre sur un autre marché qu'en se débarassant de ce marché là et donc rompre les liens du mariage. Il ne peut avoir qu'un seul Corge (marché). Ce marché en retour a signé une clause d'exclusivité avec le moulin (Foo) et ne peut donc être associé qu'à ce moulin et ne vendre que les denrées de ce moulin. Ils se connaissent. Mais le moulin pourrait vivre sans son marché (les fermes peuvent payer pour le stockage), le marché cependant ne pourrait pas vendre sans le moulin. Si il y a un divorce, la dirigeante du marché perd tout mais le moulin continue de fonctionner.

Grâce à ce système la vie est florissante dans le village: le moulin, ses fermes partenaires, sa forêt pour ses espace de stockage et le marché exclusif via les liens du mariage contribue à un système économique prospère et préserve l'union par le mariage catholique monogame entre dirigeant du moulin et dirigeante du marché. 

Cependant, en cas de divorce avec le marché, la triste réalité est que trés souvent encore dans nos sociétés la femme qui n'a travaillé que pour son mari peut tout perdre, ici l'accord exclusif au moulin fait qu'elle ne pourra pas vendre les denrée du moulin car Corge ne peut exister sans Foo.


