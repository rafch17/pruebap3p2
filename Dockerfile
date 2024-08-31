# Usa una imagen oficial de PostgreSQL como base
FROM postgres:latest

# Establece variables de entorno necesarias para PostgreSQL
ENV POSTGRES_DB=mi_basedatos
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin123

# Copia el archivo SQL con la creación de tablas e inserts en la carpeta de inicio de PostgreSQL
# (Opcional) Si tienes un script SQL para inicializar la base de datos
# COPY ./init.sql /docker-entrypoint-initdb.d/

# Expone el puerto de PostgreSQL
EXPOSE 5432

# Este comando ya se encuentra en la imagen base de PostgreSQL, por lo que es opcional repetirlo.
# CMD ["postgres"]
