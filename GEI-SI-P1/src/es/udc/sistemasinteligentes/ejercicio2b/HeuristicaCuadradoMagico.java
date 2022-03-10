package es.udc.sistemasinteligentes.ejercicio2b;

import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.Heuristica;
import es.udc.sistemasinteligentes.apartado2a.ProblemaCuadradoMagico.*;

public class HeuristicaCuadradoMagico extends Heuristica {//mañana buscar una que sea decente
    private boolean contiene(int[][] arr, int z){
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr[i].length;j++){
                if(arr[i][j]==z){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public float evalua(Estado e) {
        EstadoCuadrado esAs= (EstadoCuadrado)e;
        int [][] prub= esAs.getEstado();
        int diag=0,diag1=0;
        int sum=0;
        boolean casillas=false, casillas1=false;
        int cumplir=(((prub.length)*(prub.length*prub.length+1))/2);
        int z=prub.length;
        int limit= (int)Math.pow(prub.length,2);
        for(int i=0;i<prub.length;i++){
            diag+=prub[i][i];
            if(prub[i][i]==0){
                casillas=true;
            }
        }
        if(diag!=cumplir && !casillas){
            return 100000;
        }
        diag=0;
        casillas=false;
        for(int i=0;i<prub.length;i++){
            if(z>0){
                z--;
            }

            diag+=prub[z][i];
            if(prub[z][i]==0){
                casillas=true;
            }
        }
        if(diag!=cumplir && !casillas){
            return 100000;
        }
        casillas=false;
        casillas1=false;
        for(int i=0;i<prub.length;i++){
            diag=0;
            diag1=0;
            for(int j=0;j<prub[i].length;j++){
                if(prub[i][j]==0){
                    sum++;
                }
                diag+=prub[i][j];
                if(prub[i][j]==0){
                    casillas=true;
                }
                diag1+=prub[j][i];
                if(prub[j][i]==0){
                    casillas1=true;
                }
            }
            if(diag!=cumplir && !casillas){
                return 100000;
            }
            if(diag1!=cumplir && !casillas1){
                return 100000;
            }
        }
        return sum;

    }
}