package co.istad.di_resource.dto;

public record ProductDto(Integer id,
                         String uuid,
                         String name,
                         Double price,
                         Integer qty,
                         Boolean status){
}
