<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.layout.ColumnConstraints?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.RowConstraints?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<BorderPane fx:id="profilePane" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" stylesheets="@StartStyles.css" xmlns="http://javafx.com/javafx/15.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.ProfilePageController">
   <top>
      <HBox fx:id="hBox" alignment="CENTER_LEFT" prefHeight="95.0" prefWidth="600.0" spacing="20.0" BorderPane.alignment="CENTER">
         <children>
            <ImageView fx:id="profilePic" fitHeight="155.0" fitWidth="159.0" pickOnBounds="true" preserveRatio="true">
               <HBox.margin>
                  <Insets />
               </HBox.margin></ImageView>
            <VBox alignment="CENTER" prefHeight="166.0" prefWidth="234.0" spacing="20.0">
               <children>
                  <Label alignment="CENTER" style="-fx-font-size: 36; -fx-font-family: System;" text="My Profile">
                     <font>
                        <Font size="36.0" />
                     </font>
                  </Label>
                  <Label fx:id="nameLabel" style="-fx-font-size: 22; -fx-font-family: Bodoni;" text="Name Label">
                     <font>
                        <Font name="Bodoni MT" size="22.0" />
                     </font>
                  </Label>
               </children>
            </VBox>
            <Button fx:id="chatButton" mnemonicParsing="false" text="View Chats" />
         </children>
         <opaqueInsets>
            <Insets />
         </opaqueInsets>
         <padding>
            <Insets bottom="5.0" left="5.0" right="5.0" top="5.0" />
         </padding>
      </HBox>
   </top>
   <center>
      <GridPane alignment="CENTER" prefHeight="151.0" prefWidth="471.0" BorderPane.alignment="CENTER">
        <columnConstraints>
          <ColumnConstraints halignment="CENTER" hgrow="NEVER" maxWidth="-Infinity" minWidth="10.0" prefWidth="150.0" />
          <ColumnConstraints halignment="CENTER" hgrow="NEVER" maxWidth="-Infinity" minWidth="10.0" prefWidth="150.0" />
        </columnConstraints>
        <rowConstraints>
          <RowConstraints maxHeight="-Infinity" minHeight="30.0" prefHeight="70.0" valignment="CENTER" vgrow="NEVER" />
          <RowConstraints maxHeight="-Infinity" minHeight="10.0" prefHeight="70.0" valignment="CENTER" vgrow="NEVER" />
        </rowConstraints>
         <children>
            <Button fx:id="buySectionButton" alignment="CENTER" contentDisplay="CENTER" mnemonicParsing="false" onAction="#buyButtonResponse" prefHeight="53.0" prefWidth="135.0" text="Buy" GridPane.halignment="CENTER" GridPane.rowIndex="1" GridPane.valignment="CENTER">
               <font>
                  <Font size="14.0" />
               </font>
            </Button>
            <Button fx:id="sellSectionButton" mnemonicParsing="false" onAction="#sellButtonResponse" prefHeight="54.0" prefWidth="130.0" text="Sell" GridPane.columnIndex="1" GridPane.halignment="CENTER" GridPane.rowIndex="1">
               <font>
                  <Font size="14.0" />
               </font>
            </Button>
            <Label prefHeight="54.0" prefWidth="135.0" style="-fx-font-size: 30;" text="Business?" GridPane.columnSpan="2" />
         </children>
      </GridPane>
   </center>
</BorderPane>
