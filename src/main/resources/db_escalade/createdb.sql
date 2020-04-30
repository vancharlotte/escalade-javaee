
ALTER DATABASE db_escalade OWNER TO admin;

CREATE TABLE public.booking (
    booking_id integer NOT NULL,
    status character varying(255) NOT NULL,
    topo_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.booking OWNER TO admin;


CREATE SEQUENCE public.booking_booking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.booking_booking_id_seq OWNER TO admin;


ALTER SEQUENCE public.booking_booking_id_seq OWNED BY public.booking.booking_id;


CREATE TABLE public.comment (
    comment_id integer NOT NULL,
    description character varying(300) NOT NULL,
    "time" timestamp without time zone NOT NULL,
    title character varying(20) NOT NULL,
    site_id integer,
    user_id integer
);


ALTER TABLE public.comment OWNER TO admin;

CREATE SEQUENCE public.comment_comment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_comment_id_seq OWNER TO admin;


ALTER SEQUENCE public.comment_comment_id_seq OWNED BY public.comment.comment_id;

CREATE TABLE public.role (
    role_id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO admin;

CREATE SEQUENCE public.role_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_role_id_seq OWNER TO admin;

ALTER SEQUENCE public.role_role_id_seq OWNED BY public.role.role_id;

CREATE TABLE public.site (
    site_id integer NOT NULL,
    checked boolean NOT NULL,
    city character varying(255) NOT NULL,
    departement character varying(255) NOT NULL,
    description character varying(5000) NOT NULL,
    name character varying(50) NOT NULL,
    nbroutes character varying(255) NOT NULL,
    quotationmax character varying(255) NOT NULL,
    quotationmin character varying(255) NOT NULL,
    user_id integer
);


ALTER TABLE public.site OWNER TO admin;

CREATE SEQUENCE public.site_site_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.site_site_id_seq OWNER TO admin;

ALTER SEQUENCE public.site_site_id_seq OWNED BY public.site.site_id;


CREATE TABLE public.topo (
    topo_id integer NOT NULL,
    available boolean NOT NULL,
    city character varying(255) NOT NULL,
    departement character varying(255) NOT NULL,
    description character varying(1000) NOT NULL,
    name character varying(50) NOT NULL,
    release_date character varying(255) NOT NULL,
    user_id integer
);


ALTER TABLE public.topo OWNER TO admin;


CREATE SEQUENCE public.topo_topo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_topo_id_seq OWNER TO admin;

ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;

CREATE TABLE public.users (
    user_id integer NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL,
    role_id integer
);


ALTER TABLE public.users OWNER TO admin;

CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_id_seq OWNER TO admin;

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;


ALTER TABLE ONLY public.booking ALTER COLUMN booking_id SET DEFAULT nextval('public.booking_booking_id_seq'::regclass);

ALTER TABLE ONLY public.comment ALTER COLUMN comment_id SET DEFAULT nextval('public.comment_comment_id_seq'::regclass);

ALTER TABLE ONLY public.role ALTER COLUMN role_id SET DEFAULT nextval('public.role_role_id_seq'::regclass);

ALTER TABLE ONLY public.site ALTER COLUMN site_id SET DEFAULT nextval('public.site_site_id_seq'::regclass);

ALTER TABLE ONLY public.topo ALTER COLUMN topo_id SET DEFAULT nextval('public.topo_topo_id_seq'::regclass);

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
