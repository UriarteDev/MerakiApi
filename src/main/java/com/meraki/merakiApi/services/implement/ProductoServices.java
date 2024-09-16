package com.meraki.merakiApi.services.implement;

import com.meraki.merakiApi.apis.ProductoController;
import com.meraki.merakiApi.model.Producto;
import com.meraki.merakiApi.repository.IProductoRepository;
import com.meraki.merakiApi.services.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices implements IProductoServices {

    IProductoRepository _productoRepository;
    //IClienteRepository _clienteRepository;//

    @Autowired
    public ProductoServices(IProductoRepository productoRepository){
        _productoRepository = productoRepository;
        //_clienteRepository = productoRepository;//
    }

    @Override
    public List<Producto> GetAllProductos() {
        return _productoRepository.findAll();
    }

    @Override
    public Producto FindProductoById(int id) {
        Optional<Producto> rowInDB = _productoRepository.findById(id);
        if(rowInDB.isPresent()) {
            return rowInDB.get();
        } else
            return new Producto();
    }

    @Override
    public Producto SaveProducto(Producto entity) {
        Producto productoSaved = _productoRepository.save(entity);
        return productoSaved;
    }

    @Override
    public List<Producto> SearchProducto(int id) {
        return List.of();
    }

    @Override
    public Producto UpdateProducto(int id, Producto newProductData) {
        // Buscar el producto existente en la base de datos por su ID
        Optional<Producto> productoExistente = _productoRepository.findById(id);

        // Si el producto existe, actualizar los campos
        if(productoExistente.isPresent()) {
            Producto producto = productoExistente.get();

            // Actualizar los campos del producto con los nuevos datos
            producto.setNombre(newProductData.getNombre());
            producto.setPrecio(newProductData.getPrecio());
            producto.setDetalle(newProductData.getDetalle());
            producto.setCategoria(newProductData.getCategoria());
            // Agregar cualquier otro campo que se necesite actualizar

            // Guardar el producto actualizado en la base de datos
            return _productoRepository.save(producto);
        } else {
            // Si el producto no existe, lanzar una excepción o devolver null
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    @Override
    public void DeleteProducto(int id) {
        Optional<Producto> productoExistente = _productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            _productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

}
