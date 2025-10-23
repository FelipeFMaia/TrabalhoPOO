package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe encapsula todos os elementos de uma fase do jogo.
 * Ela implementa Serializable para poder ser salva em arquivo (Requisito 5).
 */

public class Fase implements Serializable {

    // Substitui o 'faseAtual' que estava em Tela.java
    private ArrayList<Personagem> personagens;
    
    // É útil manter uma referência direta ao herói para fácil acesso
    private Hero hero;
    
    // Informações de controle da fase
    private int numeroDaFase;
    private int totalDeItensColetaveis; // Ex: quantos diamantes você precisa pegar

    /**
     * Construtor da Fase.
     * @param numeroDaFase O número da fase (1 a 5) que deve ser carregada.
     */
    public Fase(int numeroDaFase) {
        this.numeroDaFase = numeroDaFase;
        this.personagens = new ArrayList<>();
        this.totalDeItensColetaveis = 0; // O método de carregamento define isso
        
        carregarFase(numeroDaFase);
    }

    /**
     * Método principal para construir a fase.
     * É aqui que você vai adicionar os personagens de cada uma das 5 fases.
     */
    private void carregarFase(int numero) {
        // O 'switch' é perfeito para definir suas 5 fases
        switch (numero) {
            case 1:
                // Exemplo: Carregando os personagens que você tinha no construtor de Tela.java
                
                // 1. Criar e adicionar o Herói
                // A posição inicial do herói na fase 1
                this.hero = new Hero("Robbo.png", 0, 7); 
                this.personagens.add(this.hero);

                // 2. Adicionar Itens, Inimigos e Obstáculos
                this.personagens.add(new ZigueZague("bomba.png", 5, 5));
                this.personagens.add(new BichinhoVaiVemHorizontal("roboPink.png", 3, 3));
                this.personagens.add(new BichinhoVaiVemHorizontal("roboPink.png", 6, 6));
                this.personagens.add(new BichinhoVaiVemVertical("Caveira.png", 10, 10));
                this.personagens.add(new Caveira("caveira.png", 9, 1));
                this.personagens.add(new Chaser("chaser.png", 12, 12));
                
                // Ex: A Esfera poderia ser um item coletável
                this.personagens.add(new Esfera("esfera.png", 10, 13));
                
                // TODO: Adicione aqui os seus itens coletáveis (ex: Diamantes)
                // this.personagens.add(new Diamante("diamante.png", 5, 2));
                // this.personagens.add(new Diamante("diamante.png", 5, 3));
                
                // 3. Definir a condição de vitória
                // Ex: se você adicionou 2 diamantes, defina o total.
                // this.totalDeItensColetaveis = 2; 
                
                break;

            case 2:
                // TODO: Definir a Fase 2
                // 1. Criar e adicionar o Herói (em uma nova posição)
                this.hero = new Hero("Robbo.png", 1, 1); // Posição inicial da fase 2
                this.personagens.add(this.hero);

                // 2. Adicionar novos inimigos e itens
                this.personagens.add(new Chaser("chaser.png", 10, 10));
                this.personagens.add(new Chaser("chaser.png", 10, 11));
                
                // 3. Definir a condição de vitória
                // this.totalDeItensColetaveis = ...;
                break;
            
            // TODO: Criar os cases 3, 4 e 5
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    // --- MÉTODOS DE ACESSO ---
    // Precisamos que as outras classes (Tela, ControleDeJogo) possam acessar
    // a lista de personagens e o herói.

    public ArrayList<Personagem> getPersonagens() {
        return this.personagens;
    }

    public Hero getHero() {
        return this.hero;
    }

    // --- MÉTODOS DE CONTROLE ---
    // Métodos para adicionar/remover personagens (úteis para o Req. 6 [cite: 93, 94, 95] e para coletar itens)

    public void addPersonagem(Personagem p) {
        this.personagens.add(p);
    }

    public void removePersonagem(Personagem p) {
        this.personagens.remove(p);
    }

    /**
     * TODO: Implementar a lógica de vitória (Requisito 3).
     * Este método será chamado por ControleDeJogo para saber se a fase acabou.
     * @return true se a condição de vitória foi atingida, false caso contrário.
     */
    public boolean isFaseConcluida() {
        // Exemplo de lógica: contar quantos "Diamantes" ainda existem na fase.
        // Se for 0, o jogador venceu.
        
        int itensRestantes = 0;
        for (Personagem p : this.personagens) {
            // TODO: Substituir 'Esfera' pela sua classe de item coletável
            if (p instanceof Esfera) { 
                itensRestantes++;
            }
        }
        
        // Se não houver mais itens do tipo 'Esfera', a fase está concluída.
        return itensRestantes == 0;
        
        // (Você pode querer usar a variável 'totalDeItensColetaveis' 
        //  em conjunto com uma variável 'itensColetados' no Heroi, por exemplo)
    }
}