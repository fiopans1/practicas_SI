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
            sol.append("\n");
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
        public AccionCuadrado(int x,int y,int valor){
            this.x=x;
            this.y=y;
            this.valor=valor;
        }
        @Override
        public String toString() {
            return ("Casilla["+x+"]["+y+"]=>["+valor+"]");
        }

        @Override
        public boolean esAplicable(Estado es) {
            EstadoCuadrado esAs= (EstadoCuadrado)es;
            if(esAs.estado[x][y]!=0){
                return false;

            }
            return true;
        }

        @Override
        public Estado aplicaA(Estado es) {
            EstadoCuadrado esAs= (EstadoCuadrado)es;
            int[][] estado= esAs.estado;
            int [][] est= new int[estado.length][estado.length];
            for(int i=0;i<estado.length;i++){
                for(int j=0;j<estado[i].length;j++){
                    est[i][j]=estado[i][j];
                }
            }
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
        int z=prub.length;
        int limit= (int)Math.pow(prub.length,2);
        for(int i=0;i<prub.length;i++){
            diag+=prub[i][i];
        }
        if(diag!=cumplir){
            return false;
        }
        diag=0;
        for(int i=0;i<prub.length;i++){
            if(z>0){
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
                if(1>prub[i][j] || prub[i][j]>limit){
                    return false;
                }
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
    public Accion[] acciones(Estado es) {//mejorar esto(no hace falta generar estados que no son posibles)
        int x=0,y=0;
        boolean encontrado=false;
        EstadoCuadrado esAs= (EstadoCuadrado) es;
        ArrayList<AccionCuadrado> accs= new ArrayList<>();
        int [][] estado= esAs.estado;
        int lim= (int)Math.pow(estado.length,2);
        for(int i=0;i< estado.length;i++){
            for(int j=0;j< estado[i].length;j++){
                if(estado[i][j]==0 && !encontrado){
                    x=i;
                    y=j;
                    encontrado=true;

                }
            }
        }
        if(!encontrado){
        return new Accion[0];
        }else{
            for(int i=1;i<= lim;i++){
                accs.add(new AccionCuadrado(x,y,i));
            }
        }
        Accion[] accs1= new Accion[accs.size()];
        accs.toArray(accs1);
        return accs1;
    }

}
