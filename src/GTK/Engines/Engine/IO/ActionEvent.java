package GTK.Engines.Engine.IO;

/**
 * Created By:      Assaf, On 24/02/2020
 * Description:     This class representing a unified input events from all types of controllers.
 *                  This class allows to implement only once for all types of controllers or devices.
 *                  Adapting all events to a single class.
 *                  * While the flag consumed is not marked this event will be handled by lower states
 *
 * Types Handled:   Mouse,Keyboard,Touch.
 * Events Handled:  Click,Press,Release,Movement,Dragging,Typing,Entering,Exiting.
 */
public class ActionEvent
{
    private static int counter = 0;

    public final int ID;
    public final Type type;
    public final Event event;
    public final float x;
    public final float y;
    public final int keyCode;
    public final boolean isAltDown;
    public final boolean isControlDown;
    public final boolean isShiftDown;
    public final long createdTime;
    public boolean consumed;

    public enum Event
    {
        CLICK,PRESS,RELEASE,MOVE,DRAG,TYPED,ENTER,EXIT,OTHER
    }

    public enum Type
    {
        MOUSE,KEYBOARD,TOUCH,OTHER
    }

    //<editor-fold desc="Virtual Keys">
    /** Virtual Key Codes **/

    public static final int VK_ENTER          = '\n';
    public static final int VK_BACK_SPACE     = '\b';
    public static final int VK_TAB            = '\t';
    public static final int VK_SHIFT          = 0x10;
    public static final int VK_CONTROL        = 0x11;
    public static final int VK_ALT            = 0x12;
    public static final int VK_CAPS_LOCK      = 0x14;
    public static final int VK_ESCAPE         = 0x1B;
    public static final int VK_SPACE          = 0x20;
    public static final int VK_PAGE_UP        = 0x21;
    public static final int VK_PAGE_DOWN      = 0x22;
    public static final int VK_END            = 0x23;
    public static final int VK_HOME           = 0x24;

    public static final int VK_LEFT           = 0x25;
    public static final int VK_UP             = 0x26;
    public static final int VK_RIGHT          = 0x27;
    public static final int VK_DOWN           = 0x28;

    public static final int VK_COMMA          = 0x2C;
    public static final int VK_MINUS          = 0x2D;
    public static final int VK_PERIOD         = 0x2E;
    public static final int VK_SLASH          = 0x2F;

    public static final int VK_0              = 0x30;
    public static final int VK_1              = 0x31;
    public static final int VK_2              = 0x32;
    public static final int VK_3              = 0x33;
    public static final int VK_4              = 0x34;
    public static final int VK_5              = 0x35;
    public static final int VK_6              = 0x36;
    public static final int VK_7              = 0x37;
    public static final int VK_8              = 0x38;
    public static final int VK_9              = 0x39;

    public static final int VK_SEMICOLON      = 0x3B;
    public static final int VK_EQUALS         = 0x3D;

    public static final int VK_A              = 0x41;
    public static final int VK_B              = 0x42;
    public static final int VK_C              = 0x43;
    public static final int VK_D              = 0x44;
    public static final int VK_E              = 0x45;
    public static final int VK_F              = 0x46;
    public static final int VK_G              = 0x47;
    public static final int VK_H              = 0x48;
    public static final int VK_I              = 0x49;
    public static final int VK_J              = 0x4A;
    public static final int VK_K              = 0x4B;
    public static final int VK_L              = 0x4C;
    public static final int VK_M              = 0x4D;
    public static final int VK_N              = 0x4E;
    public static final int VK_O              = 0x4F;
    public static final int VK_P              = 0x50;
    public static final int VK_Q              = 0x51;
    public static final int VK_R              = 0x52;
    public static final int VK_S              = 0x53;
    public static final int VK_T              = 0x54;
    public static final int VK_U              = 0x55;
    public static final int VK_V              = 0x56;
    public static final int VK_W              = 0x57;
    public static final int VK_X              = 0x58;
    public static final int VK_Y              = 0x59;
    public static final int VK_Z              = 0x5A;

    public static final int VK_OPEN_BRACKET   = 0x5B;
    public static final int VK_BACK_SLASH     = 0x5C;
    public static final int VK_CLOSE_BRACKET  = 0x5D;

    public static final int VK_NUMPAD0        = 0x60;
    public static final int VK_NUMPAD1        = 0x61;
    public static final int VK_NUMPAD2        = 0x62;
    public static final int VK_NUMPAD3        = 0x63;
    public static final int VK_NUMPAD4        = 0x64;
    public static final int VK_NUMPAD5        = 0x65;
    public static final int VK_NUMPAD6        = 0x66;
    public static final int VK_NUMPAD7        = 0x67;
    public static final int VK_NUMPAD8        = 0x68;
    public static final int VK_NUMPAD9        = 0x69;

    public static final int VK_MULTIPLY       = 0x6A;
    public static final int VK_ADD            = 0x6B;
    public static final int VK_SEPARATOR      = 0x6C;
    public static final int VK_SUBTRACT       = 0x6D;
    public static final int VK_DECIMAL        = 0x6E;
    public static final int VK_DIVIDE         = 0x6F;
    public static final int VK_DELETE         = 0x7F; /* ASCII DEL */
    public static final int VK_NUM_LOCK       = 0x90;
    public static final int VK_SCROLL_LOCK    = 0x91;

    public static final int VK_F1             = 0x70;
    public static final int VK_F2             = 0x71;
    public static final int VK_F3             = 0x72;
    public static final int VK_F4             = 0x73;
    public static final int VK_F5             = 0x74;
    public static final int VK_F6             = 0x75;
    public static final int VK_F7             = 0x76;
    public static final int VK_F8             = 0x77;
    public static final int VK_F9             = 0x78;
    public static final int VK_F10            = 0x79;
    public static final int VK_F11            = 0x7A;
    public static final int VK_F12            = 0x7B;

    public static final int VK_PRINTSCREEN    = 0x9A;
    public static final int VK_INSERT         = 0x9B;
    public static final int VK_HELP           = 0x9C;
    public static final int VK_BACK_QUOTE     = 0xC0;
    public static final int VK_QUOTE          = 0xDE;
    public static final int VK_KP_UP          = 0xE0;
    public static final int VK_KP_DOWN        = 0xE1;
    public static final int VK_KP_LEFT        = 0xE2;
    public static final int VK_KP_RIGHT       = 0xE3;


    public static final int VK_AMPERSAND                = 0x96;
    public static final int VK_ASTERISK                 = 0x97;
    public static final int VK_QUOTEDBL                 = 0x98;
    public static final int VK_LESS                     = 0x99;
    public static final int VK_GREATER                  = 0xa0;
    public static final int VK_BRACELEFT                = 0xa1;
    public static final int VK_BRACERIGHT               = 0xa2;
    public static final int VK_AT                       = 0x0200;
    public static final int VK_COLON                    = 0x0201;
    public static final int VK_CIRCUMFLEX               = 0x0202;
    public static final int VK_DOLLAR                   = 0x0203;
    public static final int VK_EXCLAMATION_MARK         = 0x0205;
    public static final int VK_INVERTED_EXCLAMATION_MARK = 0x0206;
    public static final int VK_LEFT_PARENTHESIS         = 0x0207;
    public static final int VK_NUMBER_SIGN              = 0x0208;
    public static final int VK_PLUS                     = 0x0209;
    public static final int VK_RIGHT_PARENTHESIS        = 0x020A;
    public static final int VK_UNDERSCORE               = 0x020B;
    public static final int VK_WINDOWS                  = 0x020C;
    //</editor-fold>

    /**
     * Constructor
     * @param type - Type of the controller that fired the event
     * @param event - Type of the event that was fired
     * @param x - x position of the controller coordinates if needed
     * @param y - y position of the controller coordinates if needed
     * @param keyCode  - key code of the event that was fired if needed
     * @param isAltDown - is alt key was down when the event fired if exist
     * @param isControlDown - is control key was down when the event fired if exist
     * @param isShiftDown - is shift key was down when the event fired if exist
     * @param createdTime - the time that the event fired
     */
    public ActionEvent(Type type,Event event, float x, float y,int keyCode,boolean isAltDown, boolean isControlDown, boolean isShiftDown, long createdTime)
    {
        ID = counter++;

        this.type = type;
        this.event = event;
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;

        this.isAltDown = isAltDown;
        this.isShiftDown = isShiftDown;
        this.isControlDown = isControlDown;

        this.createdTime = createdTime;

        consumed = false;
    }
}
