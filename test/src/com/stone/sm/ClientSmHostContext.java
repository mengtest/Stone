/*
 * ex: set ro:
 * DO NOT EDIT.
 * generated by smc (http://smc.sourceforge.net/)
 * from file : ClientSmHostContext.sm
 */

package com.stone.sm;

import com.stone.sm.host.ClientSmHost;

public class ClientSmHostContext
    extends statemap.FSMContext
{
//---------------------------------------------------------------
// Member methods.
//

    public ClientSmHostContext(ClientSmHost owner)
    {
        super (MapClient.Default);

        _owner = owner;
    }

    public ClientSmHostContext(ClientSmHost owner, ClientSmHostState initState)
    {
        super (initState);

        _owner = owner;
    }

    public void enterStartState()
    {
        getState().Entry(this);
        return;
    }

    public void battle()
    {
        _transition = "battle";
        getState().battle(this);
        _transition = "";
        return;
    }

    public void battleEnd()
    {
        _transition = "battleEnd";
        getState().battleEnd(this);
        _transition = "";
        return;
    }

    public void connect(String host, int port)
    {
        _transition = "connect";
        getState().connect(this, host, port);
        _transition = "";
        return;
    }

    public void enterScene(String puid, int sceneId)
    {
        _transition = "enterScene";
        getState().enterScene(this, puid, sceneId);
        _transition = "";
        return;
    }

    public void login(String puid)
    {
        _transition = "login";
        getState().login(this, puid);
        _transition = "";
        return;
    }

    public void start()
    {
        _transition = "start";
        getState().start(this);
        _transition = "";
        return;
    }

    public ClientSmHostState getState()
        throws statemap.StateUndefinedException
    {
        if (_state == null)
        {
            throw(
                new statemap.StateUndefinedException());
        }

        return ((ClientSmHostState) _state);
    }

    protected ClientSmHost getOwner()
    {
        return (_owner);
    }

    public void setOwner(ClientSmHost owner)
    {
        if (owner == null)
        {
            throw (
                new NullPointerException(
                    "null owner"));
        }
        else
        {
            _owner = owner;
        }

        return;
    }

//---------------------------------------------------------------
// Member data.
//

    transient private ClientSmHost _owner;

    public static abstract class ClientSmHostState
        extends statemap.State
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected ClientSmHostState(String name, int id)
        {
            super (name, id);
        }

        protected void Entry(ClientSmHostContext context) {}
        protected void Exit(ClientSmHostContext context) {}

        protected void battle(ClientSmHostContext context)
        {
            Default(context);
        }

        protected void battleEnd(ClientSmHostContext context)
        {
            Default(context);
        }

        protected void connect(ClientSmHostContext context, String host, int port)
        {
            Default(context);
        }

        protected void enterScene(ClientSmHostContext context, String puid, int sceneId)
        {
            Default(context);
        }

        protected void login(ClientSmHostContext context, String puid)
        {
            Default(context);
        }

        protected void start(ClientSmHostContext context)
        {
            Default(context);
        }

        protected void Default(ClientSmHostContext context)
        {
            throw (
                new statemap.TransitionUndefinedException(
                    "State: " +
                    context.getState().getName() +
                    ", Transition: " +
                    context.getTransition()));
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }

    /* package */ static abstract class MapClient
    {
    //-----------------------------------------------------------
    // Member methods.
    //

    //-----------------------------------------------------------
    // Member data.
    //

        //-------------------------------------------------------
        // Constants.
        //
        public static final MapClient_None None =
            new MapClient_None("MapClient.None", 0);
        public static final MapClient_Connected Connected =
            new MapClient_Connected("MapClient.Connected", 1);
        public static final MapClient_Authed Authed =
            new MapClient_Authed("MapClient.Authed", 2);
        public static final MapClient_Game Game =
            new MapClient_Game("MapClient.Game", 3);
        public static final MapClient_Battle Battle =
            new MapClient_Battle("MapClient.Battle", 4);
        private static final MapClient_Default Default =
            new MapClient_Default("MapClient.Default", -1);

    }

    protected static class MapClient_Default
        extends ClientSmHostState
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected MapClient_Default(String name, int id)
        {
            super (name, id);
        }

        protected void start(ClientSmHostContext context)
        {


            (context.getState()).Exit(context);
            context.setState(MapClient.None);
            (context.getState()).Entry(context);
            return;
        }
    //-----------------------------------------------------------
    // Member data.
    //
    }

    private static final class MapClient_None
        extends MapClient_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private MapClient_None(String name, int id)
        {
            super (name, id);
        }

        protected void connect(ClientSmHostContext context, String host, int port)
        {
            ClientSmHost ctxt = context.getOwner();


            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.log(host + ":" + port);
            }
            finally
            {
                context.setState(MapClient.Connected);
                (context.getState()).Entry(context);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }

    private static final class MapClient_Connected
        extends MapClient_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private MapClient_Connected(String name, int id)
        {
            super (name, id);
        }

        protected void login(ClientSmHostContext context, String puid)
        {
            ClientSmHost ctxt = context.getOwner();


            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.log(String.format("%s login.", puid));
            }
            finally
            {
                context.setState(MapClient.Authed);
                (context.getState()).Entry(context);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }

    private static final class MapClient_Authed
        extends MapClient_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private MapClient_Authed(String name, int id)
        {
            super (name, id);
        }

        protected void enterScene(ClientSmHostContext context, String puid, int sceneId)
        {
            ClientSmHost ctxt = context.getOwner();


            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.log(String.format("%s enterScene %d.", puid, sceneId));
            }
            finally
            {
                context.setState(MapClient.Game);
                (context.getState()).Entry(context);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }

    private static final class MapClient_Game
        extends MapClient_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private MapClient_Game(String name, int id)
        {
            super (name, id);
        }

        protected void battle(ClientSmHostContext context)
        {
            ClientSmHost ctxt = context.getOwner();


            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.log("battle state.");
            }
            finally
            {
                context.setState(MapClient.Battle);
                (context.getState()).Entry(context);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }

    private static final class MapClient_Battle
        extends MapClient_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private MapClient_Battle(String name, int id)
        {
            super (name, id);
        }

        protected void battleEnd(ClientSmHostContext context)
        {
            ClientSmHost ctxt = context.getOwner();


            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.log("battle end.");
            }
            finally
            {
                context.setState(MapClient.Game);
                (context.getState()).Entry(context);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }
}

/*
 * Local variables:
 *  buffer-read-only: t
 * End:
 */
