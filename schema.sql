
    create table Categoria (
        Categorias varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Categorias_de_entidades (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Ciudades (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        provincia_id bigint,
        primary key (id)
    )

    create table Ciudades_Proveedores (
        Ciudades_id bigint not null,
        proveedores_id integer not null
    )

    create table ClasificacionEmpresa (
        ClasificacionEmpresa varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Compras (
        id bigint generated by default as identity (start with 1),
        cantidad_presupuesto integer,
        entidad_id integer not null,
        entidad_tipo integer not null,
        fecha varbinary(255),
        monto_total double,
        requiere_presupuesto boolean,
        moneda_id bigint,
        proveedor_id integer,
        primary key (id)
    )

    create table Documentos_comerciales (
        id integer generated by default as identity (start with 1),
        numero integer not null,
        tipo_documento_comercial_id bigint,
        compra_id bigint,
        primary key (id)
    )

    create table Entidad (
        tipo_entidad varchar(31) not null,
        id bigint generated by default as identity (start with 1),
        codigoIGJ varchar(255),
        cuit varchar(255),
        direccion_postal varchar(255),
        nombre_ficticio varchar(255),
        razon_social varchar(255),
        nombre varchar(255),
        categoria_id bigint,
        clasificacion_id bigint,
        entidad_juridica_id bigint,
        categoria_entidad_id bigint,
        primary key (id)
    )

    create table Etiquetas (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Etiquetas_Proveedores (
        Etiquetas_id bigint not null,
        proveedores_id integer not null
    )

    create table Items (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Items_de_compra (
        compra_id bigint not null,
        item_id bigint not null,
        cantidad integer not null,
        precio double,
        moneda_id bigint,
        numero integer,
        nombre integer,
        primary key (compra_id, item_id)
    )

    create table Items_del_presupuesto (
        item_id bigint not null,
        presupuesto_id bigint not null,
        cantidad integer not null,
        precio double,
        primary key (item_id, presupuesto_id)
    )

    create table JoinEntidadBase (
        nombre varchar(255),
        id bigint not null,
        primary key (id)
    )

    create table JoinEntidadJuridica (
        codigoIGJ varchar(255),
        cuit varchar(255),
        direccion_postal varchar(255),
        nombreFicticio varchar(255),
        razonSocial varchar(255),
        id bigint not null,
        primary key (id)
    )

    create table Medios_de_pago (
        compra_id integer not null,
        tipo_medio_pago_id integer not null,
        numero integer not null,
        primary key (compra_id, tipo_medio_pago_id)
    )

    create table Monedas (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Paises (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        moneda_id bigint,
        region_id bigint,
        primary key (id)
    )

    create table Presupuestos (
        id bigint generated by default as identity (start with 1),
        fecha varbinary(255),
        moneda_id bigint,
        proveedor_id integer,
        compra_id bigint,
        primary key (id)
    )

    create table Proveedores (
        id integer generated by default as identity (start with 1),
        altura integer not null,
        apellido varchar(255),
        calle varchar(255),
        cuit varchar(255),
        dni varchar(255),
        nombre varchar(255),
        piso varchar(255),
        razon_social varchar(255),
        ciudad_id bigint,
        primary key (id)
    )

    create table Provincias (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        pais_id bigint,
        primary key (id)
    )

    create table Regiones (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Roles (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table TPCEntidadBase (
        id bigint not null,
        nombre varchar(255),
        primary key (id)
    )

    create table TPCEntidadJuridica (
        id bigint not null,
        codigoIGJ varchar(255),
        cuit varchar(255),
        direccion_postal varchar(255),
        nombreFicticio varchar(255),
        razonSocial varchar(255),
        primary key (id)
    )

    create table Tipos_documentos_comerciales (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Tipos_medio_de_pago (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        primary key (id)
    )

    create table Usuarios (
        id bigint generated by default as identity (start with 1),
        nombre varchar(255),
        hash varchar(255),
        rol_id bigint,
        primary key (id)
    )

    create table entidad_join (
        id bigint generated by default as identity (start with 1),
        primary key (id)
    )

    alter table Ciudades 
        add constraint FK_jqq4ce9cm763kej9skp9kefxy 
        foreign key (provincia_id) 
        references Provincias

    alter table Ciudades_Proveedores 
        add constraint FK_e09fgooslnop5i01tn4u7gjed 
        foreign key (proveedores_id) 
        references Proveedores

    alter table Ciudades_Proveedores 
        add constraint FK_qe4d74qvx67xafwir64hor7u3 
        foreign key (Ciudades_id) 
        references Ciudades

    alter table Compras 
        add constraint FK_pwqjjeu6bnyll3d7gckmnsigu 
        foreign key (moneda_id) 
        references Monedas

    alter table Compras 
        add constraint FK_18kx33qmwsj9h49hxwuttuphl 
        foreign key (proveedor_id) 
        references Proveedores

    alter table Documentos_comerciales 
        add constraint FK_aeey1ct6gl1ix21u3o394neip 
        foreign key (tipo_documento_comercial_id) 
        references Tipos_documentos_comerciales

    alter table Documentos_comerciales 
        add constraint FK_iwgv8ng9q88exxli5s0ixm685 
        foreign key (compra_id) 
        references Compras

    alter table Entidad 
        add constraint FK_80o0otto4a1hahbogdlsx759d 
        foreign key (categoria_id) 
        references Categoria

    alter table Entidad 
        add constraint FK_nmjhjkdrjiouxn76awt0ivcd1 
        foreign key (clasificacion_id) 
        references ClasificacionEmpresa

    alter table Entidad 
        add constraint FK_hpaa53wuccwmu8325wwxrq7ka 
        foreign key (entidad_juridica_id) 
        references Entidad

    alter table Entidad 
        add constraint FK_3g7enh26wmig4nw23x1euonsx 
        foreign key (categoria_entidad_id) 
        references Categorias_de_entidades

    alter table Etiquetas_Proveedores 
        add constraint FK_729c3n5m3nmhbl02cgn7s23ib 
        foreign key (proveedores_id) 
        references Proveedores

    alter table Etiquetas_Proveedores 
        add constraint FK_t4of2hqmed09v6jpp3myx6x1 
        foreign key (Etiquetas_id) 
        references Etiquetas

    alter table Items_de_compra 
        add constraint FK_e8jvidxfc4b5lvwng1fhoruts 
        foreign key (moneda_id) 
        references Monedas

    alter table Items_de_compra 
        add constraint FK_cr6itc7jma2nu1hp4ahxalgbb 
        foreign key (compra_id) 
        references Compras

    alter table Items_de_compra 
        add constraint FK_8vj3dq64liax1ncqm0y9f408k 
        foreign key (item_id) 
        references Items

    alter table Items_del_presupuesto 
        add constraint FK_lb02adehdaua28ngfuuayuigh 
        foreign key (presupuesto_id) 
        references Presupuestos

    alter table JoinEntidadBase 
        add constraint FK_l098jv78rkgmtmvjo2qg8la32 
        foreign key (id) 
        references entidad_join

    alter table JoinEntidadJuridica 
        add constraint FK_iec0ybanda1dpj96qwi4iyc54 
        foreign key (id) 
        references entidad_join

    alter table Medios_de_pago 
        add constraint FK_rnr13u298xeq0sfekmo0987ni 
        foreign key (compra_id) 
        references Compras

    alter table Medios_de_pago 
        add constraint FK_to2nos7k20rvonoutl7n13i01 
        foreign key (tipo_medio_pago_id) 
        references Tipos_medio_de_pago

    alter table Paises 
        add constraint FK_ooca51cq15m6ul5tyb18riaor 
        foreign key (moneda_id) 
        references Monedas

    alter table Paises 
        add constraint FK_485f5at7pa40c2ug15kwj0n17 
        foreign key (region_id) 
        references Regiones

    alter table Presupuestos 
        add constraint FK_5sx7tj6ms4lul7sb2dbglf7g0 
        foreign key (moneda_id) 
        references Monedas

    alter table Presupuestos 
        add constraint FK_tia29gihl1h86vpbaq5hc1996 
        foreign key (proveedor_id) 
        references Proveedores

    alter table Presupuestos 
        add constraint FK_hju37tsvb77rqpat4kk3uxwrs 
        foreign key (compra_id) 
        references Compras

    alter table Proveedores 
        add constraint FK_ek7xqbkb9bfvq6dfoau9iomy0 
        foreign key (ciudad_id) 
        references Ciudades

    alter table Provincias 
        add constraint FK_59a7otbmp8yj5k1c4f64nr89m 
        foreign key (pais_id) 
        references Paises

    alter table Usuarios 
        add constraint FK_gdwoheuffntsgxcvkhh1r9lv2 
        foreign key (rol_id) 
        references Roles

    create sequence hibernate_sequence start with 1
