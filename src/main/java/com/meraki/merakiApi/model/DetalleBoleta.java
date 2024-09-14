package com.meraki.merakiApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class DetalleBoleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;
    @ManyToOne
    @JoinColumn(name = "IdBoleta", nullable = false)
    private Boleta idBoleta;
    @ManyToOne
    @JoinColumn(name = "IdProducto", nullable = false)
    private Producto idProducto;
    private int cantidad;
}
