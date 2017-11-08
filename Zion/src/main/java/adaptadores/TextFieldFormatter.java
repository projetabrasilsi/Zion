package adaptadores;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.enums.Enum_Aux_Mascaras;


public class TextFieldFormatter {/*Declaração dos componentes.*/
    private TextField textField;
    private DatePicker datePicker;
    /*Variavel que vai contem a mascara selecionada para caso seja exibido
    o formato da mascara.*/
    private Enum_Aux_Mascaras maskSelecionada;
    /*Variavel para verificação se passou no construtor um DatePicker*/
    private boolean usarDatePicker;
   
    public TextFieldFormatter(TextField textField) {
        this.textField = textField;

    }

    /**
     * Passe um DatePicker que terá a mascara.
     *
     * @param datePicker
     */
    public TextFieldFormatter(DatePicker datePicker) {
        this.datePicker = datePicker;
        /*Informa que voi passado um DatePicker*/
        this.usarDatePicker = true;
    }

    /**
     * Passe o tipo da Mascara. Ex: setMask(MaskFormatter.TEL_8DIG);
     *
     * @param maskType
     */
    public void setMask(Enum_Aux_Mascaras maskType) {
 

    	this.maskSelecionada = maskType;
        if (!usarDatePicker) {

            switch (maskType) {
                case TEL8DG :
                    maskTel8Dig();
                    break;
                case TEL9DG:
                    maskTel9Dig();
                    break;
                case CPF:
                    maskCpf();
                    break;
                case CNPJ:
                	maskCnpj();
                    break;
                case SEMMASC:
                    maskSemMasc();
                    break;
                default:
                    break;
            }
        } else {
            switch (maskType) {
                case DATABARRA:
                    maskDataBarra();
                    break;
                case DATATRACO:
                    maskDataTraco();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que iniciar a mascara.
     */
    private void maskTel8Dig() {
        /*evento que captura os dados digitados*/
        textField.setOnKeyTyped((KeyEvent evento) -> {

            /*verifico se o que está sendo digitado é um numero*/
            if (!"0123456789".contains(evento.getCharacter())) {
                /*usando o método consume,e como se o que o usuario digitou não tivesse efeito, ex
                ele digitou uma letra, mas essa letra não apareçe pq bloqueamos o evento que faz ela aperecer na tela.*/
                evento.consume();
            }
            /*verificamos se o caracter foi digitado ou apagado se caso apagado ele é igual a zero.*/
            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 9:
                        /*subString so retornar os caracteres entre aquelas posições
                        fazemos isso para apagar o caractere - que colocamos na mascara.*/
                        textField.setText(textField.getText().substring(0, 8));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    default:
                        break;
                }

            } else if (textField.getText().length() == 14) {
                /*verificamos se já chegou o limite de numeros digitados
                lembrando que estamos contando todos os caracteres que estão visiveis*/

                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    /*Adicionamos o parentese no primeiro caracter.Obs:
                    lembrando que cada caractere digitado e como se estivesse em um array
                    então o primeiro caracter fica na posição 0*/
                    textField.setText("(" + textField.getText());
                    /*movemos sempre a letra para o ultimo lugar, sem isso a letra voltaria para o primeiro*/
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    /*como adicionamos um caractere parentese, aumenta mais um, então o segundo
                    numero digitado é o 3*/
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 9:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskTel9Dig() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }
            } else if (textField.getText().length() == 15) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    textField.setText("(" + textField.getText());
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskCpf() {

        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
            	

                switch (textField.getText().length()) {
                    case 11:
                        textField.setText(textField.getText().substring(0, 9));
                        
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 7:
                        textField.setText(textField.getText().substring(0, 6));
                        
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 14) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 3:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 7:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 11:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }
    
    
    private void maskCnpj() {

        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
            	//consume - retira o carecter inválido
                evento.consume();
            } 

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 16:
                        textField.setText(textField.getText().substring(0, 12));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 11:
                        textField.setText(textField.getText().substring(0, 8));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 7:
                        textField.setText(textField.getText().substring(0, 5));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 1));
                        textField.positionCaret(textField.getText().length());
                        break;    
                }

            } else if (textField.getText().length() == 18) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 2:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 6:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "/");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 15:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;    
            }

        });
    }

    

    @SuppressWarnings("unused")
	private void maskRg() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 2:
                        textField.setText(textField.getText().substring(0, 1));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 6:
                        textField.setText(textField.getText().substring(0, 5));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 12) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 2:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 6:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });

    }
    
    
    
    private void maskSemMasc() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
                       
           
        });

    }

    private void maskDataBarra() {
        datePicker.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (datePicker.getEditor().getText().length()) {
                    case 2:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 1));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                    case 5:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 4));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                }
            } else if (datePicker.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (datePicker.getEditor().getText().length()) {
                case 2:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
                case 5:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
            }

        });
    }

    private void maskDataTraco() {
        datePicker.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (datePicker.getEditor().getText().length()) {
                    case 2:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 1));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                    case 5:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 4));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                }
            } else if (datePicker.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (datePicker.getEditor().getText().length()) {
                case 2:
                    datePicker.getEditor().setText(datePicker.getEditor().getText()+"-");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
                case 5:
                    datePicker.getEditor().setText(datePicker.getEditor().getText()+"-");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
            }

        });
    }

    /**
     * Exibi no componente o formato de máscara selecionado. Obs: Utilizar
     * somente depois do método setMask()
     */
    public void showMask() {
        switch (this.maskSelecionada) {
            case TEL8DG:
                textField.setPromptText("(__) ____-____");
                break;
            case TEL9DG:
                textField.setPromptText("(__) _____-____");
                break;
            case CPF:
                textField.setPromptText("___.___.___-__");
                break;
            case CNPJ:
                textField.setPromptText("__.___.___/____-__");
                break;
            case DATABARRA:
                datePicker.setPromptText("__/__/____");
                break;
            case DATATRACO:
                datePicker.setPromptText("__-__-____");
                break;
            default:
                break;
        }
    }

    /**
     * Adicione um TextField, forneça a mascara e se deseja que seja exibida a
     * mascara.
     *
     * @param field
     * @param maskType
     * @param showMask
     */
    public void addComponente(TextField field, Enum_Aux_Mascaras maskType, boolean showMask) {
    	TextFieldFormatter formatter = new TextFieldFormatter(textField);
        formatter.setMask(maskType);
        if (showMask) {
            formatter.showMask();
        }
    }

    /**
     * Adicione um DatePicker, forneça a mascara e se deseja que seja exibida a
     * mascara.
     *
     * @param datePicker
     * @param maskType
     * @param showMask
     */
    public void addComponente(DatePicker datePicker, Enum_Aux_Mascaras maskType, boolean showMask) {
    	TextFieldFormatter formatter = new TextFieldFormatter(datePicker);
        formatter.setMask(maskType);
        if (showMask) {
            formatter.showMask();
        }
    }
}