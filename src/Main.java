import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Figura[] figuras = new Figura[9];
        int contador = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Rectángulo");
            System.out.println("2. Crear Triángulo");
            System.out.println("3. Crear Círculo");
            System.out.println("4. Mostrar resultados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la base del rectángulo: ");
                    double baseRect = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double alturaRect = scanner.nextDouble();
                    figuras[contador] = new Rectangulo(baseRect, alturaRect);
                    contador++;
                    System.out.println("Rectángulo creado exitosamente");
                    break;

                case 2:
                    System.out.print("Ingrese la base del triángulo: ");
                    double baseTri = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double alturaTri = scanner.nextDouble();
                    System.out.print("Ingrese el lado 1 del triángulo: ");
                    double lado1 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 2 del triángulo: ");
                    double lado2 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 3 del triángulo: ");
                    double lado3 = scanner.nextDouble();
                    figuras[contador] = new Triangulo(baseTri, alturaTri, lado1, lado2, lado3);
                    contador++;
                    System.out.println("Triángulo creado exitosamente");
                    break;

                case 3:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    figuras[contador] = new Circulo(radio);
                    contador++;
                    System.out.println("Círculo creado exitosamente");
                    break;

                case 4:
                    if (contador > 0) {
                        for (int i = 0; i < contador; i++) {
                            System.out.println("\nFigura " + (i + 1) + ":");
                            System.out.println("Área: " + figuras[i].calcularArea());
                            System.out.println("Perímetro: " + figuras[i].calcularPerimetro());
                        }
                    } else {
                        System.out.println("No hay figuras creadas");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        scanner.close();
    }
}




abstract class Figura {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}


class Rectangulo extends Figura {
    private double base;
    private double altura;


    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }


    @Override
    public double calcularArea() {
        return base * altura;
    }


    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}


class Triangulo extends Figura {
    private double base;
    private double altura;
    private double lado1;
    private double lado2;
    private double lado3;


    public Triangulo(double base, double altura, double lado1, double lado2, double lado3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }


    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }


    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }
}


class Circulo extends Figura {
    private double radio;


    public Circulo(double radio) {
        this.radio = radio;
    }


    @Override
    public double calcularArea() {
        return 3.1416 * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * 3.1416 * radio;
    }
}