package sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import sistema.entidades.Cargo;
import sistema.entidades.Funcionario;
import sistema.telas.CargosConsultar;
import sistema.telas.CargosEditar;
import sistema.telas.CargosInserir;
import sistema.telas.FuncionariosConsultar;
import sistema.telas.FuncionariosEditar;
import sistema.telas.FuncionariosInserir;
import sistema.telas.Inicio;
import sistema.telas.Login;
import sistema.telas.RelatoriosCargos;
import sistema.telas.RelatoriosSalarios;
import sistema.entidades.*;



public class Navegador {
    
    // Menu
    private static boolean menuConstruido;
    private static boolean menuHabilitado;
    private static JMenuBar menuBar;
    private static JMenu menuArquivo, menuFuncionarios, menuCargos, menuRelatorios;
    private static JMenuItem miSair, miFuncionariosConsultar, miFuncionariosCadastrar, miCargosConsultar;
    private static JMenuItem miCargosCadastrar, miRelatoriosCargos, miRelatoriosSalarios;
    
    public static void login(){
        Componentes.tela = new Login();
        Componentes.frame.setTitle("Funcionários");
        Navegador.atualizarTela();
    }
    
    public static void inicio(){
        Componentes.tela = new Inicio();
        Componentes.frame.setTitle("Funcionários");
        Navegador.atualizarTela();
    }
    
    public static void funcionariosCadastrar(){
        Componentes.tela = new FuncionariosInserir();   
        Componentes.frame.setTitle("Funcionários - Cadastrar funcionários");     
        Navegador.atualizarTela();
    }
    
    public static void funcionariosConsultar(){
        Componentes.tela = new FuncionariosConsultar();
        Componentes.frame.setTitle("Funcionários - Consultar funcionários");     
        Navegador.atualizarTela();
    }
    
    public static void funcionariosEditar(Funcionario funcionario){
        Componentes.tela = new FuncionariosEditar(funcionario);  
        Componentes.frame.setTitle("Funcionário - Editar funcionários");           
        Navegador.atualizarTela();
    }
    
    public static void cargosCadastrar(){
        Componentes.tela = new CargosInserir();
        Componentes.frame.setTitle("Funcionários - Cadastrar cargos");
        Navegador.atualizarTela();
    }
    
    public static void cargosConsultar(){
        Componentes.tela = new CargosConsultar();  
        Componentes.frame.setTitle("Funcionários - Consultar cargos");      
        Navegador.atualizarTela();
    }
    
    public static void cargosEditar(Cargo cargo){
        Componentes.tela = new CargosEditar(cargo);      
        Componentes.frame.setTitle("Funcionários - Editar cargos");  
        Navegador.atualizarTela();
    }
    
    public static void relatoriosCargos(){   
        Componentes.tela = new RelatoriosCargos();
        Componentes.frame.setTitle("Funcionários - Relatórios");    
        Navegador.atualizarTela();
    }
    
    public static void relatoriosSalarios(){
        Componentes.tela = new RelatoriosSalarios();
        Componentes.frame.setTitle("Funcionários - Relatórios");    
        Navegador.atualizarTela();
    }
    
    // Método que remove a tela atual e adiciona a próxima tela
    private static void atualizarTela(){
        Componentes.frame.getContentPane().removeAll();
        Componentes.tela.setVisible(true);
        Componentes.frame.add(Componentes.tela);
        
        Componentes.frame.setVisible(true);
    }
    
    private static void construirMenu(){
        if(!menuConstruido){
            menuConstruido = true;
            
            menuBar = new JMenuBar();
            
            // menu Arquivo
            menuArquivo = new JMenu("Arquivo");
            menuBar.add(menuArquivo);
            miSair = new JMenuItem("Sair");
            menuArquivo.add(miSair);
            
            // menu Funcionários
            menuFuncionarios = new JMenu("Funcionários");
            menuBar.add(menuFuncionarios);
            miFuncionariosCadastrar = new JMenuItem("Cadastrar");
            menuFuncionarios.add(miFuncionariosCadastrar);
            miFuncionariosConsultar = new JMenuItem("Consultar");
            menuFuncionarios.add(miFuncionariosConsultar);
            
            // menu Cargos
            menuCargos = new JMenu("Cargos");
            menuBar.add(menuCargos);
            miCargosCadastrar = new JMenuItem("Cadastrar");
            menuCargos.add(miCargosCadastrar);
            miCargosConsultar = new JMenuItem("Consultar");
            menuCargos.add(miCargosConsultar);
            
            // menu Relatórios
            menuRelatorios = new JMenu("Relatórios");
            menuBar.add(menuRelatorios);
            miRelatoriosCargos = new JMenuItem("Funcionários por cargos");
            menuRelatorios.add(miRelatoriosCargos);
            miRelatoriosSalarios = new JMenuItem("Salários dos funcionários");
            menuRelatorios.add(miRelatoriosSalarios);
            
            criarEventosMenu();
            
        }
    }
    
    public static void habilitaMenu(){
        if(!menuConstruido) construirMenu();
        if(!menuHabilitado){
            menuHabilitado = true;
            Componentes.frame.setJMenuBar(menuBar);
        }
    }
    
    public static void desabilitaMenu(){
        if(menuHabilitado){
            menuHabilitado = false;
            Componentes.frame.setJMenuBar(null);
        }        
    }

    private static void criarEventosMenu() {
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Funcionario
        miFuncionariosCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionariosCadastrar();
            }
        });
        miFuncionariosConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionariosConsultar();
            }
        });
        
        // Cargos
        miCargosCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargosCadastrar();
            }
        });
        miCargosConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargosConsultar();
            }
        });
        
        miRelatoriosCargos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                relatoriosCargos();
            }
        });
        
        miRelatoriosSalarios.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                relatoriosSalarios();
            }
        });
    }
}
