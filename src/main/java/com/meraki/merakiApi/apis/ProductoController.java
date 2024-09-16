package com.meraki.merakiApi.apis;


import com.meraki.merakiApi.model.Producto;
import com.meraki.merakiApi.services.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    IProductoServices productoServices;

    @Autowired
    public ProductoController(IProductoServices productoServices){
        this.productoServices=productoServices;
    }

    @GetMapping("/Productos")
    public List<Producto> getAll(){
        return productoServices.GetAllProductos();
    }

    @GetMapping("/Productos/{id}")
    public Producto getall(@PathVariable int id){
        return productoServices.FindProductoById(id);
    }

    @PostMapping("/Producto")
    public Producto saveProducto(@RequestBody Producto entity){
        return productoServices.SaveProducto(entity);
    }

    @PutMapping("/Producto/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto updatedProducto) {
        return productoServices.UpdateProducto(id, updatedProducto);
    }

    @DeleteMapping("/Producto/{id}")
    public String deleteProducto(@PathVariable int id) {
        productoServices.DeleteProducto(id);
        return "Producto eliminado con éxito";
    }
}
