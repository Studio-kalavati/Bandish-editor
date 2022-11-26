(ns bhatkhande-editor.subs
  (:require
   [sargam.languages :refer [lang-labels]]
   [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
 ::lang
 (fn [db]
   (if (-> db :edit-props :language-en?)
     :english :hindi)))

(reg-sub
 ::lang-data
 :<- [::lang]
 (fn [lang _]
   (lang-labels lang)))

(reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))

(reg-sub
 ::edit-props
 (fn [db _]
   (-> db :edit-props)))

(reg-sub
 ::raga
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :raga)))

(reg-sub
 ::x-switch
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :x-switch)))

(reg-sub
 ::error-message
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :error-message)))

(reg-sub
 ::swaramap
 :<- [::lang]
 (fn [lang _]
   (get-in lang-labels [lang :swara-labels])))

(reg-sub
 ::composition
 (fn [db _]
   (:composition db)))

(reg-sub
 ::taal
 :<- [::composition]
 (fn [comp _]     
   (-> comp :taal)))

(reg-sub
 ::get-click-index
 (fn [db [_ _]]
   (get-in db [:edit-props :cursor-pos])))

(reg-sub
 ::show-text-popup
 (fn [db [_ _]]
   (get-in db [:edit-props :show-text-popup])))

(reg-sub
 ::get-sahitya
 (fn [db [_ [row-index bhaag-index]]]
   (get-in db [:composition :sahitya [row-index bhaag-index]])))

(reg-sub
 ::get-note-pos
 (fn [db [_ [bhaag-row-index bhaag-index note-index]]]
   (println "sub "[bhaag-row-index bhaag-index note-index])
   (get-in db [:edit-props :note-pos bhaag-row-index bhaag-index note-index])))

(reg-sub
 ::user
 (fn [db [_ _]]
   (:user db)))

(reg-sub
 ::share-url
 (fn [db [_ _]]
   (:bandish-url db)))
