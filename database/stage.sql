--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: domaineoffre; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE domaineoffre (
    iddomaine integer NOT NULL,
    libelledomaine character(50) NOT NULL
);


ALTER TABLE domaineoffre OWNER TO postgres;

--
-- Name: domaineoffre_iddomaine_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE domaineoffre_iddomaine_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE domaineoffre_iddomaine_seq OWNER TO postgres;

--
-- Name: domaineoffre_iddomaine_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE domaineoffre_iddomaine_seq OWNED BY domaineoffre.iddomaine;


--
-- Name: entreprise; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE entreprise (
    ident integer NOT NULL,
    raisonsociale character(50) NOT NULL,
    ville character(50) NOT NULL,
    rue character(50) NOT NULL,
    idsecteur integer NOT NULL,
    cp character(5),
    tel character(10)
);


ALTER TABLE entreprise OWNER TO postgres;

--
-- Name: entreprise_ident_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE entreprise_ident_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE entreprise_ident_seq OWNER TO postgres;

--
-- Name: entreprise_ident_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE entreprise_ident_seq OWNED BY entreprise.ident;


--
-- Name: offrestage; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE offrestage (
    idoffre integer NOT NULL,
    ident integer NOT NULL,
    libelleo character(50) NOT NULL,
    descriptifo character(50) NOT NULL,
    datedebuto date NOT NULL,
    dureeo integer NOT NULL,
    remuneration integer NOT NULL,
    valide boolean NOT NULL,
    iddomaine integer NOT NULL
);


ALTER TABLE offrestage OWNER TO postgres;

--
-- Name: offrestage_idoffre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE offrestage_idoffre_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE offrestage_idoffre_seq OWNER TO postgres;

--
-- Name: offrestage_idoffre_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE offrestage_idoffre_seq OWNED BY offrestage.idoffre;


--
-- Name: secteuractivite; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE secteuractivite (
    idsecteur integer NOT NULL,
    libelles character(50) NOT NULL
);


ALTER TABLE secteuractivite OWNER TO postgres;

--
-- Name: secteuractivite_idsecteur_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secteuractivite_idsecteur_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE secteuractivite_idsecteur_seq OWNER TO postgres;

--
-- Name: secteuractivite_idsecteur_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE secteuractivite_idsecteur_seq OWNED BY secteuractivite.idsecteur;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    userid integer NOT NULL,
    login text,
    password text
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: iddomaine; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY domaineoffre ALTER COLUMN iddomaine SET DEFAULT nextval('domaineoffre_iddomaine_seq'::regclass);


--
-- Name: ident; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entreprise ALTER COLUMN ident SET DEFAULT nextval('entreprise_ident_seq'::regclass);


--
-- Name: idoffre; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offrestage ALTER COLUMN idoffre SET DEFAULT nextval('offrestage_idoffre_seq'::regclass);


--
-- Name: idsecteur; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY secteuractivite ALTER COLUMN idsecteur SET DEFAULT nextval('secteuractivite_idsecteur_seq'::regclass);


--
-- Data for Name: domaineoffre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY domaineoffre (iddomaine, libelledomaine) FROM stdin;
1	Informatique                                      
2	Agriculture                                       
\.


--
-- Name: domaineoffre_iddomaine_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('domaineoffre_iddomaine_seq', 1, false);


--
-- Data for Name: entreprise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY entreprise (ident, raisonsociale, ville, rue, idsecteur, cp, tel) FROM stdin;
1	Orange                                            	Paris                                             	montagnard                                        	1	75000	986533368 
2	Bouygues                                          	Paris                                             	Merseburg                                         	2	75080	114927478 
3	Leclerc                                           	Evry                                              	Julles Valles                                     	6	91000	123778134 
4	Lambo                                             	Nice                                              	General leclerc                                   	12	6000 	545367890 
5	Sia                                               	Orleans                                           	Liberte                                           	14	45000	553147892 
6	Credit mutuel                                     	lille                                             	LANNOY                                            	5	59000	86647965  
7	Orange                                            	Lille                                             	Rue Louise Bourgeois                              	1	59800	0629588132
8	Aya la plus belle                                 	Evry                                              	1 Rue Julles Valles                               	3	91000	0629588132
9	Univ-Evry                                         	Evry                                              	Rue Charles de Gaulle                             	8	91000	0629588223
10	A                                                 	B                                                 	A                                                 	4	9    	9         
11	A                                                 	B                                                 	A                                                 	4	9    	9         
12	A                                                 	B                                                 	A                                                 	4	9    	9         
13	A                                                 	B                                                 	A                                                 	4	9    	9         
14	A                                                 	B                                                 	A                                                 	4	9    	9         
15	A                                                 	B                                                 	A                                                 	4	9    	9         
16	A                                                 	B                                                 	A                                                 	4	9    	9         
17	A                                                 	B                                                 	A                                                 	4	9    	9         
18	A                                                 	B                                                 	A                                                 	4	9    	9         
19	A                                                 	B                                                 	A                                                 	4	9    	9         
20	A                                                 	B                                                 	A                                                 	4	9    	9         
21	A                                                 	B                                                 	A                                                 	4	9    	9         
22	A                                                 	B                                                 	A                                                 	4	9    	9         
23	A                                                 	B                                                 	A                                                 	4	9    	9         
24	blabla                                            	B                                                 	A                                                 	6	9    	9         
25	darHouda                                          	B                                                 	A                                                 	7	9    	9         
26	blablaba                                          	a                                                 	a                                                 	2	8    	76        
27	liligo                                            	paris                                             	bertrand                                          	4	75001	0609090807
28	rado badola                                       	madagascar                                        	jenesaispa                                        	4	91000	0000000000
29	vhdkhd                                            	edadh                                             	idhiodh                                           	5	98635	636903030 
\.


--
-- Name: entreprise_ident_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('entreprise_ident_seq', 29, true);


--
-- Data for Name: offrestage; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY offrestage (idoffre, ident, libelleo, descriptifo, datedebuto, dureeo, remuneration, valide, iddomaine) FROM stdin;
4	3	Developpeur Java                                  	                                                  	2017-04-05	12	850	t	1
5	1	Data-visualisation                                	                                                  	2017-05-04	7	1080	t	1
13	5	Assistant MOA                                     	                                                  	2017-03-08	6	500	t	2
1	27	Developeur Full stack                             	Très bon stage                                    	2017-01-17	10	0	f	1
2	2	assistante photocopies                            	 faire des photocopies                            	2017-01-01	7	0	f	1
3	1	photocopies                                       	stagiaire blabla                                  	2017-01-12	7	0	f	1
4	2	PHOTOCOPIEUR                                      	photo                                             	2016-01-01	6	0	f	1
5	28	GZDIHDO                                           	GBEFII                                            	2016-01-14	7	0	f	2
\.


--
-- Name: offrestage_idoffre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('offrestage_idoffre_seq', 5, true);


--
-- Data for Name: secteuractivite; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY secteuractivite (idsecteur, libelles) FROM stdin;
1	agriculture                                       
2	publique                                          
3	Industriel                                        
4	Aeoronautique                                     
5	Services                                          
6	Electronique                                      
7	Mecanique                                         
8	BTP                                               
9	Finance                                           
10	Management                                        
11	Droit                                             
12	Informatique                                      
13	Pharmaceutique                                    
14	Nucleaire                                         
\.


--
-- Name: secteuractivite_idsecteur_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secteuractivite_idsecteur_seq', 1, false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (userid, login, password) FROM stdin;
1	ayam	amaou
2	houda	123
\.


--
-- Name: domaineoffre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY domaineoffre
    ADD CONSTRAINT domaineoffre_pkey PRIMARY KEY (iddomaine);


--
-- Name: entreprise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY entreprise
    ADD CONSTRAINT entreprise_pkey PRIMARY KEY (ident);


--
-- Name: secteuractivite_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY secteuractivite
    ADD CONSTRAINT secteuractivite_pkey PRIMARY KEY (idsecteur);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (userid);


--
-- Name: entreprise_idsecteur_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entreprise
    ADD CONSTRAINT entreprise_idsecteur_fkey FOREIGN KEY (idsecteur) REFERENCES secteuractivite(idsecteur);


--
-- Name: entreprise_idsecteur_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY entreprise
    ADD CONSTRAINT entreprise_idsecteur_fkey1 FOREIGN KEY (idsecteur) REFERENCES secteuractivite(idsecteur);


--
-- Name: offrestage_iddomaine_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offrestage
    ADD CONSTRAINT offrestage_iddomaine_fkey FOREIGN KEY (iddomaine) REFERENCES domaineoffre(iddomaine);


--
-- Name: offrestage_iddomaine_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offrestage
    ADD CONSTRAINT offrestage_iddomaine_fkey1 FOREIGN KEY (iddomaine) REFERENCES domaineoffre(iddomaine);


--
-- Name: offrestage_ident_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offrestage
    ADD CONSTRAINT offrestage_ident_fkey FOREIGN KEY (ident) REFERENCES entreprise(ident);


--
-- Name: offrestage_ident_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY offrestage
    ADD CONSTRAINT offrestage_ident_fkey1 FOREIGN KEY (ident) REFERENCES entreprise(ident);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

