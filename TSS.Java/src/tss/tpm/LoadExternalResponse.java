package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/** This command is used to load an object that is not a Protected Object into the TPM.
 *  The command allows loading of a public area or both a public and sensitive area.
 */
public class LoadExternalResponse extends TpmStructure
{
    /** Handle of type TPM_HT_TRANSIENT for the loaded object  */
    public TPM_HANDLE handle;
    
    /** Name of the loaded object  */
    public byte[] name;
    
    public LoadExternalResponse() { handle = new TPM_HANDLE(); }
    
    /** TpmMarshaller method  */
    @Override
    public void toTpm(TpmBuffer buf)
    {
        handle.toTpm(buf);
        buf.writeSizedByteBuf(name);
    }
    
    /** TpmMarshaller method  */
    @Override
    public void initFromTpm(TpmBuffer buf)
    {
        handle = TPM_HANDLE.fromTpm(buf);
        name = buf.readSizedByteBuf();
    }
    
    /** @deprecated Use {@link #toBytes()} instead  */
    public byte[] toTpm () { return toBytes(); }
    
    /** Static marshaling helper  */
    public static LoadExternalResponse fromBytes (byte[] byteBuf) 
    {
        return new TpmBuffer(byteBuf).createObj(LoadExternalResponse.class);
    }
    
    /** @deprecated Use {@link #fromBytes()} instead  */
    public static LoadExternalResponse fromTpm (byte[] byteBuf)  { return fromBytes(byteBuf); }
    
    /** Static marshaling helper  */
    public static LoadExternalResponse fromTpm (TpmBuffer buf) 
    {
        return buf.createObj(LoadExternalResponse.class);
    }
    
    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPM2_LoadExternal_RESPONSE");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }
    
    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPM_HANDLE", "handle", handle);
        _p.add(d, "byte", "name", name);
    }
}

//<<<
