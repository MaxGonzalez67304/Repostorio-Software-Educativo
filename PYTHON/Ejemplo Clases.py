class Puerta:
    abierta = True
    material = "madera"
    alto = 200
    ancho = 10
    largo = 100

    def __init__(self, abierta, material) -> None: # Constructor
        self.abierta = abierta
        self.material = material

    def volumen(self):
        return self.alto * self.ancho * self.largo

puerta = Puerta(False, "hierro")
print(puerta.abierta)
print(puerta.material)
print(puerta.volumen())