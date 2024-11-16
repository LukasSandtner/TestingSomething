/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Lukas
 */
public class Diagonala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int pocetPrvku = 5;
        int pocetPrvku2 = 5;
        int[][] pole = new int[pocetPrvku][pocetPrvku2];

        if (isCtvercovaMatice(pocetPrvku, pocetPrvku2)) {

            vypisPole(pocetPrvku, pole);

            soucetDiagonalyZleva(pocetPrvku, pole);

            soucetDiagonalyZprava(pocetPrvku, pole);

            dalsiSoucetDiagonalyZleva(pocetPrvku, pole);

            dalsiSoucetDiagonalyZprava(pocetPrvku, pole);

            soucetPodHlavniDiagonalou(pocetPrvku, pole);

            soucetNadHlavniDiagonalou(pocetPrvku, pole);

            soucetNadVedlejsiDiagonalou(pocetPrvku, pole);

            soucetPodVedlejsiDiagonalou(pocetPrvku, pole);

            transponace(pocetPrvku, pole);
            
            seradit(pocetPrvku, pole);
            
        } else {
            System.out.println("Neni ctvercova matice!");
        }
    }

    private static void vypisPole(int pocetPrvku, int[][] pole) {
        System.out.println("Vypis pole: \n-----------");
        for (int i = 0; i < pocetPrvku; i++) {
            System.out.print("{ ");
            for (int j = 0; j < pole[i].length; j++) {
                pole[i][j] = (int) (Math.random() * 5) + 1;
                System.out.print(pole[i][j] + " ");
            }
            System.out.println("}");
        }

    }

    private static void soucetDiagonalyZleva(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nNulovani diagonaly zleva: \n---------------------");
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = i; j < i + 1; j++) {
                pole[i][j] = 0;
                //System.out.println(sum);
            }
        }
        for (int i = 0; i < pole.length; i++) {
            System.out.print("{");
            for (int j = 0; j < pole[0].length; j++) {
                System.out.print(" " + pole[i][j]);

            }
            System.out.println(" }");
        }
        //System.out.println(sum);
    }

    private static void soucetDiagonalyZprava(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nSoucet diagonaly zprava: \n--------------------");
        for (int i = pocetPrvku - 1; i >= 0; i--) {
            for (int j = i; j > i - 1; j--) {
                sum += pole[i][j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    private static void dalsiSoucetDiagonalyZleva(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nDalsi soucet diagonaly zleva: \n---------------");
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = pole[i].length - 1 - i; j > pole[i].length - 2 - i; j--) {
                sum += pole[i][j];
                //System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    private static void dalsiSoucetDiagonalyZprava(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("\nDalsi soucet diagonaly zprava: \n--------------");
        for (int i = pocetPrvku - 1; i >= 0; i--) {
            for (int j = pole[i].length - i - 1; j < pole[i].length - i; j++) {
                sum += pole[i][j];
                //System.out.println(pole[i][j]);
            }
        }
        System.out.println(sum);
    }

    private static void soucetPodHlavniDiagonalou(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("Soucet pod hlavni diagonalou:");
        for (int i = 1; i < pocetPrvku; i++) {
            for (int j = 0; j < i; j++) {
                sum += pole[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void soucetNadHlavniDiagonalou(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("Soucet nad hlavni diagonalou:");
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = pocetPrvku - 1; j > i; j--) {
                sum += pole[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void soucetNadVedlejsiDiagonalou(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("Soucet nad vedlejsi diagonalou:");
        for (int i = 0; i < pocetPrvku - 1; i++) {
            for (int j = 0; j < pocetPrvku - i - 1; j++) {
                sum += pole[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void soucetPodVedlejsiDiagonalou(int pocetPrvku, int[][] pole) {
        int sum = 0;
        System.out.println("Soucet pod vedlejsi diagonalou:");
        for (int i = 1; i < pocetPrvku; i++) {
            for (int j = pocetPrvku - 1; j > pocetPrvku - i - 1; j--) {
                sum += pole[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void transponace(int pocetPrvku, int[][] pole) {
        int rows = pocetPrvku;
        int columns = pocetPrvku;
        int[][] transponedMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transponedMatrix[j][i] = pole[i][j];
            }
        }

        System.out.println("Transponovana matice:");
        for (int[] row : transponedMatrix) {
            System.out.print("{ ");
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println("}");
        }
    }

    private static void seradit(int pocetPrvku, int[][] pole) {
        for (int i = 0; i < pocetPrvku; i++) {
            for (int j = 0; j < pocetPrvku - 1; j++) {
                for (int k = 0; k < pocetPrvku - j - 1; k++) {
                    if (pole[i][k] > pole[i][k + 1]) {
                        int temp = pole[i][k];
                        pole[i][k] = pole[i][k + 1];
                        pole[i][k + 1] = temp;
                    }
                }
            }
        }
        System.out.println("Serazena matice:");
        for (int[] row : pole) {
            System.out.print("{ ");
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println("}");
        }
    }

    private static boolean isCtvercovaMatice(int pocetPrvku, int pocetPrvku2) {
        return pocetPrvku == pocetPrvku2;
    }
}
