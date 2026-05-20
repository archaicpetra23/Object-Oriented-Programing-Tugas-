package edu.pradita.oop.session11;

import edu.pradita.oop.session11.decorator.*;
import edu.pradita.oop.session11.adapter.*;
import edu.pradita.oop.session11.bridge.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Session11Test {

    // DECORATOR TESTS
    @Test
    void vanillaIceCreamShouldHaveBaseDescription() {
        IceCream iceCream = new VanillaIceCream();
        assertEquals("Vanilla Ice Cream", iceCream.getDescription());
    }

    @Test
    void vanillaIceCreamShouldHaveBaseCost() {
        IceCream iceCream = new VanillaIceCream();
        assertEquals(10000, iceCream.getCost());
    }

    @Test
    void waferDecoratorShouldAddDescriptionAndCost() {
        IceCream iceCream = new WaferDecorator(new VanillaIceCream());
        assertEquals("Vanilla Ice Cream, Wafer", iceCream.getDescription());
        assertEquals(12000, iceCream.getCost());
    }

    @Test
    void sprinklesDecoratorShouldAddDescriptionAndCost() {
        IceCream iceCream = new SprinklesDecorator(new VanillaIceCream());
        assertEquals("Vanilla Ice Cream, Sprinkles", iceCream.getDescription());
        assertEquals(11500, iceCream.getCost());
    }

    @Test
    void multipleDecoratorsShouldStackProperly() {
        IceCream iceCream = new ChocolateSyrupDecorator(
                new SprinklesDecorator(
                        new WaferDecorator(new VanillaIceCream())
                )
        );
        assertEquals("Vanilla Ice Cream, Wafer, Sprinkles, Chocolate Syrup", iceCream.getDescription());
        assertEquals(16000, iceCream.getCost());
    }

    @Test
    void allToppingsShouldAccumulateCorrectly() {
        IceCream iceCream = new NutsDecorator(
                new FruitsDecorator(
                        new PockyDecorator(
                                new ChocolateSyrupDecorator(
                                        new SprinklesDecorator(
                                                new WaferDecorator(new VanillaIceCream())
                                        )
                                )
                        )
                )
        );
        assertEquals(
                "Vanilla Ice Cream, Wafer, Sprinkles, Chocolate Syrup, Pocky, Fruits, Nuts",
                iceCream.getDescription()
        );
        assertEquals(24500, iceCream.getCost());
    }

    // ADAPTER TESTS
    @Test
    void legacySensorShouldReturnFahrenheitValue() {
        LegacyFahrenheitSensor sensor = new LegacyFahrenheitSensor();
        assertEquals(86.0, sensor.getTemperatureInFahrenheit());
    }

    @Test
    void adapterShouldConvertFahrenheitToCelsius() {
        TemperatureSensor adapter = new FahrenheitToCelsiusAdapter(new LegacyFahrenheitSensor());
        assertEquals(30.0, adapter.getTemperatureInCelsius(), 0.001);
    }

    @Test
    void weatherMonitorShouldReadThroughTargetInterface() {
        WeatherMonitor monitor = new WeatherMonitor();
        TemperatureSensor adapter = new FahrenheitToCelsiusAdapter(new LegacyFahrenheitSensor());
        assertEquals(30.0, monitor.readTemperature(adapter), 0.001);
    }

    // BRIDGE TESTS
    @Test
    void tvShouldTogglePowerAndChangeVolume() {
        Device tv = new TV();
        tv.power();
        tv.volumeUp();
        assertEquals("TV -> ON, volume: 11", tv.getStatus());
    }

    @Test
    void radioShouldTogglePowerAndChangeVolume() {
        Device radio = new Radio();
        radio.power();
        radio.volumeUp();
        radio.volumeUp();
        assertEquals("Radio -> ON, volume: 7", radio.getStatus());
    }

    @Test
    void remoteControlShouldDelegateToDevice() {
        RemoteControl remote = new RemoteControl(new TV());
        remote.togglePower();
        remote.volumeUp();
        assertEquals("TV -> ON, volume: 11", remote.getStatus());
    }

    @Test
    void advancedRemoteShouldMuteByLoweringVolumeThreeTimes() {
        AdvancedRemoteControl remote = new AdvancedRemoteControl(new TV());
        remote.togglePower();
        remote.volumeUp(); // 11
        remote.volumeUp(); // 12
        remote.mute();     // 9
        assertEquals("TV -> ON, volume: 9", remote.getStatus());
    }
}