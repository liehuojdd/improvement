package com.zhuru;

class HumanFactory {
    public Human getHuman(String type) {
         if ("chinese".equals(type)) {
              return new Chinese();
         } else {
              return new American();
         }
    }
}