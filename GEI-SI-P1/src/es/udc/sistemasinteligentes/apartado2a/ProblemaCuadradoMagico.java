package es.udc.sistemasinteligentes.apartado2a;
import es.udc.sistemasinteligentes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ProblemaCuadradoMagico extends ProblemaBusqueda{
    public static class EstadoCuadrado extends Estado{
        private int [][] estado;
        public EstadoCuadrado(int [][] estado){
            this.estado=estado;

        }
        @Override
        public String toString() {
            StringBuilder sol=new StringBuilder();
            for(int i=0;i<estado.length;i++){
                sol.append("[");
                for(int j=0;j<estado[i].length;j++){
                    sol.append(estado[i][j]);
                }
                sol.append("]\n");
            }
            return sol.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EstadoCuadrado that = (EstadoCuadrado) o;
            for (int i = 0; i < estado.length; i++) {
                for (int j = 0; j < estado[i].length; j++) {
                    if (estado[i][j] != that.estado[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(estado);
        }
    }
    public static class AccionCuadrado extends Accion{
        private int x,y,valor;
        int [][] estadoInicial;
        public AccionCuadrado(int x,int y,int valor, int[][] estadoInicial){
            this.x=x;
            this.y=y;
            this.valor=valor;
            this.estadoInicial=estadoInicial;
        }
        @Override
        public String toString() {
            return ("Casilla["+x+"]["+y+"]=>["+valor+"]");
        }

        @Override
        public boolean esAplicable(Estado es) {
            EstadoCuadrado esAs= (EstadoCuadrado)es;
            if(esAs.estado[x][y]!=0){
                if(esAs.estado[x][y]!=valor){
                    return false;
                }

            }
            return true;
        }

        @Override
        public Estado aplicaA(Estado es) {
            EstadoCuadrado esAs= (EstadoCuadrado)es;
            int [][] est= esAs.estado;
            est[x][y]=valor;
            return new EstadoCuadrado(est);
        }
    }

    public ProblemaCuadradoMagico(Estado estadoInicial) {
        super(estadoInicial);
    }


    @Override
    public boolean esMeta(Estado es) {
        EstadoCuadrado esAs= (EstadoCuadrado)es;
        int [][] prub= esAs.estado;
        int diag=0,diag1=0;
        int cumplir=(((prub.length)*(prub.length*prub.length+1))/2);
        int z=prub.length-1;
        for(int i=0;i<prub.length;i++){
            diag+=prub[i][i];
        }
        if(diag!=cumplir){
            return false;
        }
        diag=0;
        for(int i=0;i<prub.length;i++){
            if(z>=0){
                z--;
            }

            diag+=prub[z][i];
        }
        if(diag!=cumplir){
            return false;
        }

        for(int i=0;i<prub.length;i++){
            diag=0;
            diag1=0;
            for(int j=0;j<prub[i].length;j++){
                diag+=prub[i][j];
                diag1+=prub[j][1];
            }
            if(diag!=cumplir || diag1!=cumplir){
                return false;
            }
        }


        return true;
    }

    @Override
    public Accion[] acciones(Estado es) {
        return new Accion[0];
    }
}
