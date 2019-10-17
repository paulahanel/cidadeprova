/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoCidade;
import dao.DaoCidade;
import javax.swing.JOptionPane;
import modelo.Cidade;
import  java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorCidade {

    public static void inserir(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setS_estado(man.jtfS_estado.getText());
        objeto.setN_habitantes(Integer.parseInt(man.jtfN_habitantes.getText()));
        objeto.setD_emancipacao(LocalDate.parse(man.jtfD_emancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setA_total(Double.parseDouble(man.jtfA_total.getText()));
        objeto.setD_capital(Integer.parseInt(man.jtfD_capital.getText()));
        
        boolean resultado = DaoCidade.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setS_estado(man.jtfS_estado.getText());
        objeto.setN_habitantes(Integer.parseInt(man.jtfN_habitantes.getText()));
        objeto.setD_emancipacao(LocalDate.parse(man.jtfD_emancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setA_total(Double.parseDouble(man.jtfA_total.getText()));
        objeto.setD_capital(Integer.parseInt(man.jtfD_capital.getText()));
        
        boolean resultado = DaoCidade.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

     public static void excluir(ManutencaoCidade man){
        Cidade objeto = new Cidade();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoCidade.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Sigla estado");
        modelo.addColumn("Número habitantes");
        modelo.addColumn("Data emancipação");
        modelo.addColumn("Área total");
        modelo.addColumn("Distância capital");
        
        List<Cidade> resultados = DaoCidade.consultar();
        for (Cidade objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getS_estado());
            linha.add(objeto.getN_habitantes());
            linha.add(objeto.getD_emancipacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getA_total());
            linha.add(objeto.getD_capital());

            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
     public static void atualizaCampos(ManutencaoCidade man, int pk){ 
        Cidade objeto = DaoCidade.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfS_estado.setText(objeto.getS_estado());
        man.jtfN_habitantes.setText(objeto.getN_habitantes().toString());
        man.jtfD_emancipacao.setText(objeto.getD_emancipacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfA_total.setText(objeto.getA_total().toString());
        man.jtfD_capital.setText(objeto.getD_capital().toString());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }

    
}
