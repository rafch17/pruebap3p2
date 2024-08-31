package com.espe.chanchay.pruebap3p2.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "cedula", nullable = false)
    private String cedula;
    @Column(name = "nombres", nullable = false,length = 100)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(name = "ingresos", length = 100)
    private Double ingresos;

    
    public Cliente(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cedula == null) {
            if (other.cedula != null)
                return false;
        } else if (!cedula.equals(other.cedula))
            return false;
        return true;
    }

}
