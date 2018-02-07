package br.com.correios.realize.seguranca;

import br.com.correios.componente.idautorizador.usuario.ItemMenu;

import java.util.*;

public class ItemMenuDecorator implements Comparable<ItemMenuDecorator> {

    private ItemMenu itemMenu;

    private Map<Integer, ItemMenuDecorator> filhos = new TreeMap<Integer, ItemMenuDecorator>();

    private List<ItemMenuDecorator> subItens = new ArrayList<>();

    /**
     * Construtor
     *
     * @param item
     */
    public ItemMenuDecorator(ItemMenu item) {
        itemMenu = item;
    }

    /**
     * @return the itemMenu
     */
    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    /**
     * @param itemMenu the itemMenu to set
     */
    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    /**
     * @return the filhos
     */
    public Map<Integer, ItemMenuDecorator> getFilhos() {
        return filhos;
    }

    /**
     * @param filhos the filhos to set
     */
    public void setFilhos(TreeMap<Integer, ItemMenuDecorator> filhos) {
        this.filhos = filhos;
    }

    /**
     * Retorna uma lista da arvore para correta iteração do ui:repeat
     *
     * @return
     */
    public List<ItemMenuDecorator> getListaDeFilhos() {
        List<ItemMenuDecorator> resultado = null;
        if (filhos.size() != 0) {
            resultado = new ArrayList<ItemMenuDecorator>();
            resultado.addAll(filhos.values());
            Collections.sort(resultado);
        }
        return resultado;
    }


    /**
     * @return the subItens
     */
    public List<ItemMenuDecorator> getSubItens() {
        return subItens;
    }

    /**
     * @param subItens the subItens to set
     */
    public void setSubItens(List<ItemMenuDecorator> subItens) {
        this.subItens = subItens;
    }

    @Override
    public int compareTo(ItemMenuDecorator outroItemMenuDecorator) {
        return this.getItemMenu().getOrdem().compareTo(outroItemMenuDecorator.getItemMenu().getOrdem());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemMenu == null) ? 0 : itemMenu.getId().getIdItemMenu().hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ItemMenuDecorator other = (ItemMenuDecorator) obj;
        if (itemMenu == null) {
            if (other.itemMenu != null) {
                return false;
            }
        } else if (!itemMenu.getId().getIdItemMenu().equals(other.getItemMenu().getId().getIdItemMenu())) {
            return false;
        }
        return true;
    }


}
