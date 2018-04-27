
FAKTURAMA:
Equivalencias:
    Factura     |Invoice
    Credito     |Credit         |Nota de Credito
    Proforma    |Proforma       |Boleta
    Nota_Envio  |Delivery       |Nota de Envio
    Pedido      |Order          |Pedido
    
    
SFS:
Formatos de Nombre y numeración:
FACTURA: ^[F][A-Z0-9]{3}-[0-9]{1,8}$|^(E001)-[0-9]{1,8}$|^[0-9]{1,4}-[0-9]{1,8}$
BOLETA: ^[B][A-Z0-9]{3}-[0-9]{1,8}$|^[0-9]{1,4}-[0-9]{1,8}$
BAJA: [R][A]-[0-9]{8}-[0-9]{1,5}
NOTA DE CREDITO: ^[BF][A-Z0-9]{3}-[0-9]{1,8}   
NOTA DE DEBITO: ^[FB][A-Z0-9]{3}-[0-9]{1,8}    