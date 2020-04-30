 INSERT INTO role
(name)
VALUES 
('ADMIN'),
('USER');

 INSERT INTO users
(username, password, email, role_id)
VALUES 
('user1' ,'1ABCDefgh','user1@gmail.com', 1),
('user2' ,'1ABCDefgh','user2@gmail.com', 2),
('user3' ,'1ABCDefgh','user3@gmail.com', 2);

INSERT INTO topo
(name, description, city, departement, available, release_date, user_id)
VALUES 
('topo1', 'description du topo1 ',  'ville', '01 - Ain', true, '2002-04-23', 1),
('topo2', 'description du topo2 ',  'ville', '01 - Ain', true, '2002-04-23', 1),
('topo3', 'description du topo3 ',  'ville', '02 - Aisne', true, '2019-05-23', 2),
('topo4', 'description du topo4 ',  'ville', '02 - Aisne', true, '2010-01-23', 2),
('topo5', 'description du topo5 ',  'ville', '02 - Aisne', true, '2010-01-23', 3),
('40 Falaises aux environs du lac d’Annecy', 'Annecy: sa vieille ville, ses rues pavées et son lac bordé de grandes parois rocheuses pour le plus grand bonheur des falaisistes. Ce topoguide de Robert Durieux est une invitation à “l’escalade plaisir” autour de la ville! Il répertorie 49 sites en Haute-Savoie avec des voies - couennes et grandes voies - avec des difficultés variées et progressives et des lignes soutenues allant du 3a au 8b+. ',  'Annecy', '74 - Haute Savoie', true, '2017-01-01', 3);


INSERT INTO booking
(status, topo_id, user_id)
VALUES
('en attente', 1, 2),
('en attente', 2, 2),
('en attente', 3, 1),
('en attente', 4, 1);

INSERT INTO site
(name, description, city, departement, checked, nbroutes, quotationMin,quotationMax, user_id)
VALUES 
('site1', 'description du site16 ',  'ville', '02 - Aisne', false, '20','4','7c', 2),
('site2', 'description du site2 ',  'ville', '01 - Ain', true, '23', '3','9a', 1),
('site3', 'description du site3 ',  'ville', '02 - Aisne', true, '19','1','6b', 2),
('site4', 'description du site4 ',  'ville', '02 - Aisne', false, '20','4','7c', 2),
('site5', 'description du site5 ',  'ville', '01 - Ain', true, '20', '1','5a', 1),
('site6', 'description du site6 ',  'ville', '01 - Ain', true, '23', '3','9a', 1),
('site7', 'description du site7 ',  'ville', '02 - Aisne', true, '19','1','6b', 2),
('site8', 'description du site8 ',  'ville', '02 - Aisne', false, '20','4','7c', 2),
('site9', 'description du site9 ',  'ville', '01 - Ain', true, '20', '1','5a', 1),
('site10', 'description du site10 ',  'ville', '01 - Ain', true, '23', '3','9a', 1),
('site11', 'description du site11',  'ville', '02 - Aisne', true, '19','1','6b', 2),
('Autoire', 'Un quart des voies d’escalade dans le Lot se trouve à Autoire. Cela devrait suffire pour parler d’un site majeur, avec 271 lignes tracées sur un superbe calcaire, et pas mal de nouveautés venues enrichir et redynamiser les lieux au cours de la dernière décennie (après une longue période de léthargie). À site majeur, cadre majeur, avec la cascade de trente mètres qui tombe au fond de la gorge entaillant le causse, et le vieux village d’Autoire, avec ses belles pierres, sorti tout droit et intact de l’époque médiévale... Si ça c’est pas du décor de cinéma ! C’est donc dans ce décor que se déroule, émergeant des chênes, longue d’un kilomètre, la barre rocheuse d’Autoire. Elle démarre sous le belvédère de Siran, par lequel se fait l’accès, et tous les secteurs se succèdent, à mi-hauteur, avec un accès aisé de barre en barre. Le rocher prend plus ou moins de dévers, change de couleur et de forme, au gré de l’inspiration des éléments et de l’usure du temps. Grimpeurs ou non, tant d’esthétique 
fait forcément vibrer une corde sensible. Pour l’escalade, le premier à avoir vibré est Patrick Moissinac, qui, en 1983, a équipé les premières voies au secteur Bolivaria, le plus court. Le site est donc suffisamment âgé pour avoir connu la grande époque du fluo et des imprimés flashy et improbables, mais il est toujours resté au goût du jour et en phase avec son époque (heureusement, car celle des années 80 était assez fatigante pour les yeux), sans bien sûr passer à côté de l’actuel engouement pour les colonnes et les jolies voies dures en dévers. Le tout dans une région assez tranquille et un brin sauvage, ce qui garantit la quasi-absence de patine sur les voies. En contrepartie, pour les soirées qui déchirent et les after animés, ce n’est pas... majeur.',  'Autoire', '46 - Lot', false, '271','5a','8b', 2),
('Arudy', 'Falaise de rocher calcaire, doté de grosses écailles qui séparent de petites dalles. Les voies mesurent jusqu’à 55 mètres de hauteur, avec des possibilités de combiner les voies pour enchaîner deux longueurs. Les couennes sont réparties sur plusieurs falaises, constituant autant de secteurs. Au cœur du cirque d’Anglas, un nouveau secteur d’initiation. Les autres: Houn de Laa (17 voies du 4c au 7b+), Sirène (15 voies du 5a au 7b+), Vénus (13 voies du 4b au 5c), Soleil (une vingtaine de voies dans toutes les nuances de 5 et de 6, et un secteur très apprécié et fréquenté), Gaufrette (une quinzaine de voies du 4c au 6b+), Sesto (une bonne vingtaine de voies, du 5a au 7b+) et La Fonderie (25 voies, 5b à 8b+) – ce dernier un cran au-dessus en termes de difficulté (avec une moyenne dans le septième degré), sur une falaise calcaire déversante à surplombante. L’équipement est partout moderne, et récent dans certains secteurs.',  'Arudy', '64 - Pyrénées Atlantique', true, '230', '3c','8b', 1),
('Annot', 'À mi-chemin entre Dignes les Bains et Nice, un peu perché dans l’arrière-pays montagnard, Annot est l’un des plus beaux spots de grimpe du Sud. Il y a là une forêt à champignons, de ceux que l’on mange en omelette, et que l’on cherche dans les sous-bois panier au bras, et de ceux sur lesquels on grimpe. Avec ses grosses boules de grès unique, ses blocs par centaines et ses voies si particulières, son sous-bois ombragé, son soleil du Sud et cette ambiance qui mêle le calme et la douceur de vivre provençale, Annot est un petit paradis de l’escalade. Dans une relative discrétion, une dynamique d’ouverture exceptionnelle a propulsé le site parmi les grands d’Europe. Et en plus, les choses ont été bien faites dès le départ, ce qui mérite d’être souligné. Le développement s’est inscrit dans une démarche de respect des lieux et de concertation avec les autres "utilisateurs" de la forêt 
(propriétaires, riverains, randonneurs, chasseurs, ramasseurs de champignons, lutins et elfes). La volonté des ouvreurs-découvreurs était d’épargner le site du "star system" attirant les foules, les mauvaises fréquentations et les ennuis, et au contraire, de le laisser prendre sa place en douceur, sans crier son existence sur tous les toits, mais sans rétention d’information non plus... La preuve, le topo est gratuit et téléchargeable sur Internet. Apparemment, et espérons que ça dure, leur volonté a été exaucée, et Annot a habilement échappé à la destinée du Disneyland du bloc. Déjà, le lieu est un peu excentré par rapport au gros des troupes dans le Sud-Est. Et puis rien n’est donné pour atteindre le pied des blocs, et encore moins leur sommet ! Grimper ici, cela se mérite. Et l’excellente réputation d’Annot n’a rien du surfait ni de l’effet de mode. À savoir au passage, si Annot est maintenant associé dans 
l’esprit de tous aux blocs de la vallée d’Argenton, il existe aussi les blocs d’Annot, si hauts qu’on y grimpe avec une corde. Ce sont d’ailleurs ces voies qui ont fait venir l’escalade à Annot, avant qu’elle ne migre sur les blocs. L’escalade y est largement artificielle, et ces murs de grès archi-lisses sont devenus grimpables à grand renfort de prises taillées (une centaine de voies, du 4c au 8c+, environ 25 m de hauteur). Et il y a aussi les grandes voies de "trad" (une centaine de voies, du 5b au 8a) qui remontent des lignes de fissures dans la plus pure tradition américaine. Une autre spécialité d’Annot.',  'Nice', '04 - Alpes de Haute Provence', true, '400', '4c','8c+', 1),
('Ailefroide', 'Préparez-vous à plonger dans un océan de granit d’une qualité constante, caractérisé par son grain féroce, qui le rend agréablement adhérent quand il s’agit de se tenir sur les prises, mais quelque peu abrasif pour la peau des doigts. Tout est là, des blocs dépassant rarement 4 m de haut, aux grandes parois dalleuses où vous embarquez pour des voyages de 400 m d’escalade. Quand aux préhensions, registre complet du granit avec en tête les fissures, réglettes et plats. En bloc, plus de 300 passages du 4c au 8b, du facile à l’extrême, sans oublier les débutants et les enfants avec des circuits créés pour eux. Idéal pour grimper en famille et faire découvrir l’activité aux plus petits. Tout autour, plus de 500 voies en plusieurs secteurs, du 3a au 8a, en couennes ou GV, sur équipement sportif impeccable ou terrain d’aventure complet. ',  'Briançon', '05 - Hautes Alpes', true, '500','3a','9a', 1),
('Ablon', 'La falaise appartient à un vallon de calcaire urgonien, parvenu jusqu’à nous sous forme de murs verticaux ou légèrement déversants, compacts et finement ciselés d’une multitude de cannelures et de picots, qui sont d’ailleurs la marque de fabrique d’Ablon. Quasiment aucun voie n’y échappe, et vos doigts s’en souviendront. Le style dominant reste les voies de continuité, et vous trouverez quelques grandes longueurs avec des prises à profusion, mais pas toutes dans le bon sens ce qui complique la lecture. Plus de 230 voies, du 4b au 8b. Pour les grimpeurs de niveau 5+ à 6b, ce sont dans les secteurs "Ligne du temps" et "Résistance et liberté" les plus adaptés. Corde de 70 m suffisante. Quelques rares voies où une corde de 80 m est nécessaire. Voies assez bien équipées, prévoir un bon jeu de dégaines.',  'Annecy', '74 - Haute Savoie', true, '230', '4b','8b', 1);


INSERT INTO comment
(description, time, title, site_id, user_id)
VALUES 
('description du comment1 sur deux lignes pour tester la taille du tableau et la remise à la ligne', '20051220 23:59:59.99', 'comment1', 16, 2),
('description du comment2 sur deux lignes pour tester la taille du tableau et la remise à la ligne', '20061225 23:59:59.99' , 'comment2', 16,2),
('description du comment3 sur deux lignes pour tester la taille du tableau et la remise à la ligne','20071224 23:59:59.99', 'comment3', 16, 1),
('description du comment4 sur deux lignes pour tester la taille du tableau et la remise à la ligne','20081223 23:59:59.99', 'comment4', 16,1),
('description du comment5 ','20091222 23:59:59.99', 'comment4', 16,1),
('description du comment6 ','20101221 23:59:59.99', 'comment4', 1,1);

