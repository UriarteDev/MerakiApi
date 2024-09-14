package com.meraki.merakiApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoleta;
    @ManyToOne
    @JoinColumn(name = "IdCliente", nullable = false)
    private Cliente cliente;
    @CreationTimestamp
    private LocalDateTime fecha;
}
