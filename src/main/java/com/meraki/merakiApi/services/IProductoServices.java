package com.meraki.merakiApi.services;

import com.meraki.merakiApi.apis.ProductoController;
import com.meraki.merakiApi.model.Producto;

import java.util.List;

public interface IProductoServices {
    List<Producto> GetAllProductos();
    Producto FindProductoById(int id);
    Producto SaveProducto(Producto entity);
    List<Producto> SearchProducto(int id);
    Producto UpdateProducto(int id, Producto newProductData);
    void DeleteProducto(int id);
}
