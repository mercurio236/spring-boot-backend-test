CREATE TABLE IF NOT EXISTS seg_usuario (
id_usuario SERIAL PRIMARY KEY, 
nm_usuario VARCHAR(255), 
ds_cidade VARCHAR(255), 
cd_uf VARCHAR(2));

CREATE TABLE cad_user (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nm_usuario VARCHAR(255),
    ds_cidade VARCHAR(255),
    cd_uf VARCHAR(2)
);