create database if not exists socialnetwork;

use socialnetwork;

create table Utilisateur (
    id                             INT NOT NULL AUTO_INCREMENT,
    username                       VARCHAR(30),
    password                       VARCHAR(30),
    firstname                      VARCHAR(30),
    lastname                       VARCHAR(30),
    email                          VARCHAR(30),
    date_nais                      date,
    CONSTRAINT PK_USER primary key (id)
)
;


create table article (
    idarticle                      INT NOT NULL AUTO_INCREMENT,
    id                        	   INT,
    titre                          VARCHAR(300),
    categorie                      VARCHAR(300),
    image                          LONGBLOB,
    video                          LONGBLOB,
    nbjaimeart                     INT,
    CONSTRAINT PK_ART primary key (idarticle),
	constraint FK_ART foreign key (id) references Utilisateur(id)
)
;

-- table index
create index article_i1 on article (id);


create table commentaire (
    idcom							INT NOT NULL AUTO_INCREMENT,
    id                        	   INT,
    idarticle                       INT,
    the_comment                    VARCHAR(300),
    nbjaimecom                     INT,
    CONSTRAINT PK_COM primary key (idcom),
	constraint FK_COM foreign key (idarticle) references article(idarticle),
    constraint FK_COM1 foreign key (id) references Utilisateur(id)
)
;

-- table index
create index commentaire_i1 on commentaire (idarticle);


create table jaime (
    idjaime							INT NOT NULL AUTO_INCREMENT,
    id                        	   INT ,
    idarticle                       INT,
    CONSTRAINT PK_JAIME primary key (idjaime),
    constraint FK_JAM foreign key (idarticle) references article(idarticle),
    constraint FK_JAM1 foreign key (id) references Utilisateur(id)
)
;

-- table index
create index jaime_i1 on jaime (idarticle);


create table friend (
    idfriend                       INT NOT NULL AUTO_INCREMENT,
    user_1                         INT,
    user_2                         INT,
    CONSTRAINT PK_Friend primary key (idfriend),
    constraint FK_USER1 foreign key (user_1) references Utilisateur(id),
    constraint FK_USER2 foreign key (user_2) references Utilisateur(id)
)
;

-- table index
create index friend_i1 on friend (user_1);
create index friend_i2 on friend (user_2);


create table message (
    idmsg                          INT NOT NULL AUTO_INCREMENT,
    msg                            VARCHAR(200),
    date_envoi                     date,
    isread                         BOOLEAN,
    sender                         INT,
    receiver                       INT,
    CONSTRAINT PK_MSG primary key (idmsg),
    constraint FK_SND foreign key (sender) references Utilisateur(id),
    constraint FK_REC foreign key (receiver) references Utilisateur(id)
)
;

-- table index
create index message_i1 on message (receiver);
create index message_i2 on message (sender);


-- load data
 
insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    1,
    'Load Balancer Certificate Upgr',
    'In Faucibus Ut',
    'Load Balancer Certificate Upgr',
    'Cubilia Curae; Proin',
    'gricelda.luebbers@aaab.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    2,
    'Mach 5 Speed Test',
    'Risus Rhoncuscras Vulputate',
    'Mach 5 Speed Test',
    'Rhoncus Nonmolestie Sit',
    'dean.bollich@aaac.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    3,
    'CMS Training',
    'Ullamcorperinterdum Et Malesua',
    'CMS Training',
    'Ipsumprimis In Faucibus',
    'milo.manoni@aaad.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    4,
    'Storage Expansion Module',
    'Id Nulla Ac',
    'Storage Expansion Module',
    'Pellentesque Proin Viverra',
    'laurice.karl@aaae.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    5,
    'Time to Market System',
    'Rhoncus Nonmolestie Sit',
    'Time to Market System',
    'Rhoncus Nonmolestie Sit',
    'august.rupel@aaaf.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    6,
    'Elastic Rightsize Automation',
    'Proin Viverra Lacinialectus',
    'Elastic Rightsize Automation',
    'Rhoncus Nonmolestie Sit',
    'salome.guisti@aaag.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    7,
    'Routing Control System',
    'Iaculis Aliquam Vestibulum',
    'Routing Control System',
    'Ipsumprimis In Faucibus',
    'lovie.ritacco@aaah.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    8,
    'ELK Site',
    'Et Ultrices Posuere',
    'ELK Site',
    'Lectus Nulla Placerat',
    'chaya.greczkowski@aaai.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    9,
    'Inventory Reduction',
    'Id Nulla Ac',
    'Inventory Reduction',
    'Nam Semper Diam',
    'twila.coolbeth@aaaj.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    10,
    'Checklist Upgrade',
    'Nulla Placerat Iaculis',
    'Checklist Upgrade',
    'Malesuada Fames Ac',
    'carlotta.achenbach@aaak.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    11,
    'Database Best Practice Documen',
    'Risusphasellus Vitae Ligula',
    'Database Best Practice Documen',
    'Volutpat Risusphasellus Vitae',
    'jeraldine.audet@aaal.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    12,
    'Risk Reduction Monitoring',
    'Ac Volutpat Risusphasellus',
    'Risk Reduction Monitoring',
    'Vestibulum Lacinia Arcu',
    'august.arouri@aaam.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    13,
    'DevOps Best Practices',
    'Nam Semper Diam',
    'DevOps Best Practices',
    'Volutpat Risusphasellus Vitae',
    'ward.stepney@aaan.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    14,
    'Airline Upgrade',
    'Iaculis Aliquam Vestibulum',
    'Airline Upgrade',
    'Lacinia Arcu In',
    'ayana.barkhurst@aaao.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    15,
    'Real World Performance Review',
    'Rhoncus Nonmolestie Sit',
    'Real World Performance Review',
    'Eget Rhoncus Nonmolestie',
    'luana.berends@aaap.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    16,
    'Java Prototype',
    'Sollicitudin Elementum Nulla',
    'Java Prototype',
    'Tincidunt Vestibulum Ante',
    'lecia.alvino@aaaq.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    17,
    'Cloud ERP System Review',
    'Sapien Suscipit Tristique',
    'Cloud ERP System Review',
    'Iaculis Aliquam Vestibulum',
    'joleen.himmelmann@aaar.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    18,
    'Geospatial Data Acquisition',
    'Cursus Porttitor Tincidunt',
    'Geospatial Data Acquisition',
    'Placerat Iaculis Aliquam',
    'monty.kinnamon@aaas.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    19,
    'Fixed Asset Tracking',
    'Et Malesuada Fames',
    'Fixed Asset Tracking',
    'Id Mattis Risus',
    'dania.grizzard@aaat.com',
    '2010-04-02'
);

insert into Utilisateur (
    id,
    username,
    password,
    firstname,
    lastname,
    email,
    date_nais
) values (
    20,
    'Datalogic System',
    'Semper Diam Suscipit',
    'Datalogic System',
    'Amet Imperdiet Ex',
    'inez.yamnitz@aaau.com',
    '2010-04-02'
);

commit;
-- load data
-- load data
 
insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    70,
    16,
    'Etiam Cursus Porttitor',
    'Rhoncus Nonmolestie Sit Amet',
    null,
    null,
    16
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	48,
    2,
    'Tincidunt Vestibulum Ante',
    'Volutpat Risusphasellus Vitae Ligula',
    null,
    null,
    50
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    26,
    19,
    'Rhoncus Nonmolestie Sit',
    'Sit Amet Lectus Nulla',
    null,
    null,
    88
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	36,
    4,
    'Dictum Lorem Sit',
    'Tincidunt Vestibulum Ante Ipsumprimis',
    null,
    null,
    38
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    79,
    10,
    'Placerat Pellentesque Proin',
    'Lectus Nulla Placerat Iaculis',
    null,
    null,
    92
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    6,
    3,
    'Nam Semper Diam',
    'Primis In Faucibus Ut',
    null,
    null,
    41
);

insert into article (
    idarticle,
	id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    13,
    9,
   'Ut Id Nulla',
    'Amet Lectus Nulla Placerat',
    null,
    null,
    16
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	92,
    9,
    'Lorem Commodo Ullamcorperinter',
    'Sit Amet Lectus Nulla',
    null,
    null,
    49
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    72,
    15,
    'Massa Pharetra Id',
    'Imperdiet Ex Etiam Cursus',
    null,
    null,
    29
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    1,
    15,
    'Massa  Id',
    'Imperdiet Ex Etiam Cursus',
    null,
    null,
    29
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	41,
    9,
    'Commodo Ullamcorperinterdum Et',
    'Sodales Proin Sit Amet',
    null,
    null,
    75
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	33,
    17,
    'Risus Rhoncuscras Vulputate',
    'Orci Luctus Et Ultrices',
    null,
    null,
    55
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    57,
    20,
    'Ultrices Posuere Cubilia',
    'Quis Consectetur Mi Venenatis',
    null,
    null,
    76
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    75,
    9,
    'Pellentesque Proin Viverra',
    'Massa Pharetra Id Mattis',
    null,
    null,
    70
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    68,
    10,
    'Lorem Commodo Ullamcorperinter',
    'Commodo Dictum Lorem Sit',
    null,
    null,
    26
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	88,
    5,
    'Massa Eu Lorem',
    'Donec Convallis Sollicitudin Elementum',
    null,
    null,
    35
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	44,
    10,
    'Ac Ante Ipsum',
    'Nam Semper Diam Suscipit',
    null,
    null,
    93
);

insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
    45,
    11,
    'Lacinialectus Quis Consectetur',
    'Ultrices Posuere Cubilia Curae;',
    null,
    null,
    99
);

insert into article (
   idarticle,
    id,
   titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	54,
    11,
    'Proin Vulputate Placerat',
    'Orci Luctus Et Ultrices',
    null,
    null,
    81
);



insert into article (
    idarticle,
    id,
    titre,
    categorie,
    image,
    video,
    nbjaimeart
) values (
	50,
    9,
    'Porttitor Tincidunt Vestibulum',
    'Ultrices Posuere Cubilia Curae;',
    null,
    null,
    89
);

commit;
-- load data
 
insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
    10,
    1,
    1,
    'Sit amet massa eu.',
    null,
    99
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
    79,
    1,
    1,
    'Massa eu lorem commodo ullamcorper.Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut id nulla ac sapien suscipit tristique ac volutpat risus.Phasellus vitae ligula commodo, dictum.',
    null,
    100
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
	62,
    1,
    1,
    'Lacinia arcu in massa pharetra, id mattis risus rhoncus.Cras vulputate porttitor ligula. Nam semper diam suscipit elementum sodales. Proin sit amet massa eu lorem commodo ullamcorper.Interdum et males',
    null,
    80
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
    4,
    1,
    1,
    'Vestibulum ante ipsumprimis in faucibus orci luctus et ultrices posuere cubilia Curae; Proin vulputate placerat pellentesque. Proin viverra lacinialectus, quis consectetur mi venenatis nec. Donec conv',
    null,
    32
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
	40,
    1,
    1,
    'Tristique ac volutpat risus.Phasellus.',
    null,
    10
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
    6,
    1,
    1,
    'Fames ac ante ipsum primis in faucibus. Ut id nulla ac sapien suscipit tristique ac volutpat risus.Phasellus vitae ligula commodo, dictum lorem sit amet, imperdiet ex. Etiam cursus porttitor tincidunt',
    null,
    15
);

insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
	73,
    1,
    1,
    'Etiam cursus porttitor tincidunt. Vestibulum ante ipsumprimis in faucibus orci luctus et ultrices posuere cubilia Curae; Proin vulputate placerat pellentesque. Proin viverra lacinialectus, quis consec',
    null,
    5
);




/*******************/
insert into commentaire (
    idcom,
    id,
    idarticle,
    the_comment,
    image,
    nbjaimecom
) values (
	33,
    1,
    1,
    'Ipsumprimis in faucibus orci luctus et ultrices posuere cubilia Curae; Proin vulputate placerat pellentesque. Proin viverra lacinialectus, quis consectetur mi venenatis nec. Donec convallis sollicitud',
    null,
    30
);


commit;
-- load data
 
insert into jaime (
    idjaime,
    id,
    idarticle
   
) values (
    1,
    1,
    1
  
);




commit;
-- load data
 
insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    59,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    96,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    23,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    35,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    95,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    93,
    1,
    1
);

/****************/

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    43,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    22,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    58,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    63,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    36,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    64,
    1,
    1
);



insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    60,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    78,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    76,
    1,
    1
);



insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    45,
    1,
    1
);

insert into friend (
    idfriend,
    user_1,
    user_2
) values (
    97,
    1,
    1
);

commit;
-- load data
 


insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    2,
    'Posuere cubilia Curae; Proin vulputate placerat pellentesque. Proin viverra lacinialectus, quis consectetur mi.',
   '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    3,
    'Consectetur mi venenatis nec. Donec convallis sollicitudin elementum. Nulla facilisi. In posuere blandit leoeget malesuada. Vivamus efficitur ipsum.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    4,
    'Non,molestie sia arcu in massr dieu lorem commodo ullamcorper.Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut id nulla.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    5,
    'Porttit et malesuada fames ac antePhasellus vitae ligula commodo, dictum lorem sit amet.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    6,
    'Faucibuverra lacinialectus.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    7,
    'Idn sit ametm primis in faucibus. Ut id n vitae ligula commodo, dictum lorem sit amet.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    8,
    'Ante ipsum primis in faucibus. Ut id nula commodo, dictum lorem sit amet, imperdiet ex. Etiam cursus.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    9,
    'Faucibuinialectus, quis consectetur mi venenatis nec. Donec convallis sollicitudin elementum. Nulla facilisi.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    10,
    'Sit nulla ac sapien suscipit tristique ac volutpat risus.Phasellus vitae ligula commodo, dictum lorem sit amet, imperdiet ex. Etiam cursus porttitor tincidunt. Vestibulum ante ipsumprimis in.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    11,
    'Elemercu, in vestibulum tellus. In sollicitudin nisi mi, pharetra grndrerit quis varius eget.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    12,
    'PhareProinibus. Ut id nulla ac sapien suscipit tristique ac volutpat risus.Phasellus.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    13,
    'Etiam ialectus, quis consectetur mi venenatis nec. Donec convallis sollicitudin elementum. Nsuere.',
     '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    14,
    'Lorem sit viverra lacinialectus, quis consectetur mi venenatis nec. Donec convallis sollicitudin.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    15,
    'Ligula. Nam semper diam suscipit elementum sodales. Proin sit amet massa eu lorem commodo.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    16,
    'Semper dique ac vols porttitor tincidunt. Vestibulum ante ipsumprimis in faucibus orci luctre.',
   '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    17,
    'Dictum lorem sit amet, is sollicitudin elementum. Nulla facilisi. In posuere blandit leoeget malesuada.',
	'2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    18,
    'Suscipit elementum sodales. nte ipsum primis in faucibus. Ut id nulla ac sapien suscipit tristique ac.',
    '2010-04-02',
    false,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    19,
    'Ipsum primis in.',
    '2010-04-02',
    true,
    1,
    1
);

insert into message (
    idmsg,
    msg,
    date_envoi,
    isread,
    sender,
    receiver
) values (
    20,
    'Sit amet.',
    '2010-04-02',
    false,
    1,
    1
);

commit;
 