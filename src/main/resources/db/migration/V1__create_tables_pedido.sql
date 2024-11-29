CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT NOT NULL,
    idProduto INT NOT NULL,
    valorTotal DOUBLE NOT NULL,
    dataCompra DATETIME NOT NULL,
    status ENUM('PENDENTE', 'PAGO') NOT NULL
);